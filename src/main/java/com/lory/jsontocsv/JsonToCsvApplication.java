package com.lory.jsontocsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JsonToCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonToCsvApplication.class, args);
		convertJsonToCsv(args[0], args[1]);
	}


	public static void convertJsonToCsv(String jsonFile, String csvFile) {
		List<Map<String, String>> flatJson = JsonFlattener.parseJson(new File(jsonFile), "UTF-8");
		CsvWriter.writeToFile(CsvWriter.getCSV(flatJson, ","), csvFile);
	}
}

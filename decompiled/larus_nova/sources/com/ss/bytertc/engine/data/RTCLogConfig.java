package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class RTCLogConfig {
    public int logFileSize;
    public String logFilenamePrefix;
    public LocalLogLevel logLevel;
    public String logPath;

    public String toString() {
        return "RTCLogConfig{log_level='" + this.logLevel + "', log_path='" + this.logPath + "', log_file_size='" + this.logFileSize + "', log_filename_prefix='" + this.logFilenamePrefix + "'}";
    }

    public RTCLogConfig(String r100) {
        this.logFileSize = 10;
        this.logLevel = LocalLogLevel.WARNING;
        this.logPath = r100;
    }

    public RTCLogConfig(LocalLogLevel r100, String r101, int r102, String r103) {
        this.logFileSize = 10;
        LocalLogLevel r104 = LocalLogLevel.INFO;
        this.logLevel = r100;
        this.logPath = r101;
        this.logFileSize = r102;
        this.logFilenamePrefix = r103;
    }

    public static RTCLogConfig create(LocalLogLevel r100, String r101, int r102, String r103) {
        return new RTCLogConfig(r100, r101, r102, r103);
    }
}

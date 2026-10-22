package com.huawei.multimedia.audiokit.utils;

import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class LogUtils {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    private static final String ERROR_MESSAGE = "log message error : ";
    public static final int INFO = 3;
    public static final int LOG_LEVEL = 6;
    public static final int VERBOSE = 5;
    public static final int WARN = 2;

    public static void debug(String r100, String r101) {
    }

    public static void error(String r100, String r101) {
    }

    public static void info(String r100, String r101) {
    }

    public static void verbose(String r100, String r101) {
    }

    public static void warn(String r100, String r101) {
    }

    private LogUtils() {
    }

    private static <T> String getMessageString(String r100, T[] r101) {
        return String.format(Locale.ENGLISH, r100.replaceAll("\\{\\}", "%s"), r101);
    L4:
        e = move-exception;
        return ERROR_MESSAGE + e.getMessage();
    }

    public static <T> void debug(String r100, String r101, T... r102) {
        if (r101 == null) goto L5;
        getMessageString(r101, r102);
        return;
    }

    public static <T> void error(String r100, String r101, T... r102) {
        if (r101 == null) goto L5;
        getMessageString(r101, r102);
        return;
    }

    public static <T> void info(String r100, String r101, T... r102) {
        if (r101 == null) goto L5;
        getMessageString(r101, r102);
        return;
    }
}

package com.bytedance.bmmt.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes8.dex */
public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static String stackTrace(Throwable r100) {
        r100.printStackTrace(new PrintWriter(new StringWriter()));
        return r100.toString();
    }
}

package com.ss.bytertc.base.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes40.dex */
public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static String cause(Throwable r100) {
        String r101 = null;
    L3:
        if (r100 == null) goto L7;
        if (r100.getCause() == null) goto L7;
        r101 = r100.getCause().toString();
        r100 = r100.getCause();
    L7:
        return r101;
    }

    public static String stackTrace(Throwable r100) {
        r100.printStackTrace(new PrintWriter(new StringWriter()));
        return r100.toString();
    }
}

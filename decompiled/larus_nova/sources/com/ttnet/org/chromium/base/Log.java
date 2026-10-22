package com.ttnet.org.chromium.base;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private static boolean isDebug() {
        return false;
    }

    private static String getCallOrigin() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        String r101 = Log.class.getName();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102].getClassName().equals(r101) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        r102 = r102 + 3;
    L10:
        return r100[r102].getFileName() + ":" + r100[r102].getLineNumber();
    }

    private Log() {
    }

    public static String getStackTraceString(Throwable r100) {
        return android.util.Log.getStackTraceString(r100);
    }

    private static Throwable getThrowableToLog(Object[] r100) {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (r100.length == 0) goto L12;
        Object r101 = r100[r100.length - 1];
        if ((r101 instanceof Throwable) == true) goto L11;
        return null;
    L11:
        return (Throwable) r101;
    }

    public static String normalizeTag(String r100) {
        if (r100.startsWith(sTagPrefix) == false) goto L6;
        return r100;
    L6:
        if (r100.startsWith(sDeprecatedTagPrefix) == false) goto L8;
        int r101 = 3;
    L10:
        return sTagPrefix + r100.substring(r101, r100.length());
    L8:
        r101 = 0;
        goto L10
    }

    public static boolean isLoggable(String r100, int r101) {
        if (isDebug() == true) goto L9;
        if (r101 > 4) goto L9;
        return false;
    L9:
        return android.util.Log.isLoggable(r100, r101);
    }

    public static void d(String r100, String r101, Object... r102) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r103 = getThrowableToLog(r102);
        formatLogWithStack(r101, r103, r102);
        if (r103 == null) goto L8;
        normalizeTag(r100);
        return;
    L8:
        normalizeTag(r100);
    }

    public static void e(String r100, String r101, Object... r102) {
        Throwable r103 = getThrowableToLog(r102);
        formatLog(r101, r103, r102);
        if (r103 == null) goto L5;
        normalizeTag(r100);
        return;
    L5:
        normalizeTag(r100);
    }

    private static String formatLog(String r100, Throwable r101, Object... r102) {
        if (r102 == null) goto L10;
        if (r101 != null) goto L7;
        if (r102.length <= 0) goto L7;
    L9:
        return String.format(Locale.US, r100, r102);
    L7:
        if (r102.length > 1) goto L9;
        return r100;
    L10:
        return r100;
    }

    private static String formatLogWithStack(String r100, Throwable r101, Object... r102) {
        return "[" + getCallOrigin() + "] " + formatLog(r100, r101, r102);
    }

    public static void i(String r100, String r101, Object... r102) {
        Throwable r103 = getThrowableToLog(r102);
        formatLog(r101, r103, r102);
        if (r103 == null) goto L5;
        normalizeTag(r100);
        return;
    L5:
        normalizeTag(r100);
    }

    public static void v(String r100, String r101, Object... r102) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r103 = getThrowableToLog(r102);
        formatLogWithStack(r101, r103, r102);
        if (r103 == null) goto L8;
        normalizeTag(r100);
        return;
    L8:
        normalizeTag(r100);
    }

    public static void w(String r100, String r101, Object... r102) {
        Throwable r103 = getThrowableToLog(r102);
        formatLog(r101, r103, r102);
        if (r103 == null) goto L5;
        normalizeTag(r100);
        return;
    L5:
        normalizeTag(r100);
    }

    public static void wtf(String r100, String r101, Object... r102) {
        Throwable r103 = getThrowableToLog(r102);
        formatLog(r101, r103, r102);
        if (r103 == null) goto L5;
        normalizeTag(r100);
        return;
    L5:
        normalizeTag(r100);
    }
}

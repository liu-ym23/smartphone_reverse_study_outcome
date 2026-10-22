package com.facebook.common.logging;

/* JADX INFO: loaded from: classes3.dex */
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler;

    public FLog() {
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    static {
        sHandler = FLogDefaultLoggingDelegate.getInstance();
    }

    private static String getTag(Class<?> r100) {
        return r100.getSimpleName();
    }

    public static boolean isLoggable(int r100) {
        return sHandler.isLoggable(r100);
    }

    public static void setLoggingDelegate(LoggingDelegate r100) {
        if (r100 == null) goto L6;
        sHandler = r100;
        return;
    L6:
        throw new IllegalArgumentException();
    }

    public static void setMinimumLoggingLevel(int r100) {
        sHandler.setMinimumLoggingLevel(r100);
    }

    public static void d(Class<?> r100, String r101) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), r101);
        return;
    }

    public static void e(Class<?> r100, String r101) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(getTag(r100), r101);
        return;
    }

    private static String formatString(String r100, Object... r101) {
        return String.format(null, r100, r101);
    }

    public static void i(Class<?> r100, String r101) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), r101);
        return;
    }

    public static void v(Class<?> r100, String r101) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), r101);
        return;
    }

    public static void w(Class<?> r100, String r101) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(getTag(r100), r101);
        return;
    }

    public static void wtf(Class<?> r100, String r101) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(getTag(r100), r101);
        return;
    }

    public static void d(String r100, String r101) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, r101);
        return;
    }

    public static void v(String r100, String r101) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(r100, r101);
        return;
    }

    public static void wtf(String r100, String r101) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(r100, r101);
        return;
    }

    public static void d(Class<?> r100, String r101, Object r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r101, new Object[]{r102}));
        return;
    }

    public static void e(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void i(Class<?> r100, String r101, Object r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r101, new Object[]{r102}));
        return;
    }

    public static void v(Class<?> r100, String r101, Object r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), formatString(r101, new Object[]{r102}));
        return;
    }

    public static void w(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void wtf(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void d(String r100, String r101, Object r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, formatString(r101, new Object[]{r102}));
        return;
    }

    public static void e(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(getTag(r100), r101, r102);
        return;
    }

    public static void i(String r100, String r101, Object r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r101, new Object[]{r102}));
        return;
    }

    public static void v(String r100, String r101, Object r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r101, new Object[]{r102}));
        return;
    }

    public static void w(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(getTag(r100), r101, r102);
        return;
    }

    public static void wtf(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(getTag(r100), r101, r102);
        return;
    }

    public static void d(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void e(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(r100, formatString(r101, r102));
        return;
    }

    public static void i(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void v(Class<?> r100, String r101, Object... r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), formatString(r101, r102));
        return;
    }

    public static void w(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(r100, formatString(r101, r102));
        return;
    }

    public static void wtf(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(r100, formatString(r101, r102));
        return;
    }

    public static void d(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), r101, r102);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(r100, r101, r102);
        return;
    }

    public static void i(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), r101, r102);
        return;
    }

    public static void v(Class<?> r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), r101, r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(r100, r101, r102);
        return;
    }

    public static void wtf(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(r100, r101, r102);
        return;
    }

    public static void d(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        d(r100, formatString(r101, r102));
        return;
    }

    public static void i(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r101, r102));
        return;
    }

    public static void v(String r100, String r101, Object... r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r101, r102));
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, r101, r102);
        return;
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, r101, r102);
        return;
    }

    public static void v(String r100, String r101, Throwable r102) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, r101, r102);
        return;
    }

    public static void d(Class<?> r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void e(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(getTag(r100), formatString(r102, r103), r101);
        return;
    }

    public static void i(Class<?> r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void v(Class<?> r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void w(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(5) == false) goto L6;
        sHandler.w(r100, formatString(r102, r103), r101);
        return;
    }

    public static void wtf(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(getTag(r100), formatString(r102, r103), r101);
        return;
    }

    public static void d(String r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void e(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.e(r100, formatString(r102, r103), r101);
        return;
    }

    public static void i(String r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void v(String r100, String r101, Object r102, Object r103) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r101, new Object[]{r102, r103}));
        return;
    }

    public static void w(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (isLoggable(5) == false) goto L6;
        w(r100, formatString(r102, r103), r101);
        return;
    }

    public static void wtf(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(6) == false) goto L6;
        sHandler.wtf(r100, formatString(r102, r103), r101);
        return;
    }

    public static void d(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r102, r103), r101);
        return;
    }

    public static void i(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r102, r103), r101);
        return;
    }

    public static void v(Class<?> r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), formatString(r102, r103), r101);
        return;
    }

    public static void d(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(3) == false) goto L6;
        d(r100, formatString(r102, r103), r101);
        return;
    }

    public static void i(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r102, r103), r101);
        return;
    }

    public static void v(String r100, Throwable r101, String r102, Object... r103) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r102, r103), r101);
        return;
    }

    public static void d(Class<?> r100, String r101, Object r102, Object r103, Object r104) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void i(Class<?> r100, String r101, Object r102, Object r103, Object r104) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void v(String r100, String r101, Object r102, Object r103, Object r104) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void d(String r100, String r101, Object r102, Object r103, Object r104) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void i(String r100, String r101, Object r102, Object r103, Object r104) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void v(Class<?> r100, String r101, Object r102, Object r103, Object r104) {
        if (isLoggable(2) == false) goto L6;
        v(r100, formatString(r101, new Object[]{r102, r103, r104}));
        return;
    }

    public static void d(Class<?> r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(getTag(r100), formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }

    public static void i(Class<?> r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(getTag(r100), formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }

    public static void v(Class<?> r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(getTag(r100), formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }

    public static void d(String r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(3) == false) goto L6;
        sHandler.d(r100, formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }

    public static void i(String r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(4) == false) goto L6;
        sHandler.i(r100, formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }

    public static void v(String r100, String r101, Object r102, Object r103, Object r104, Object r105) {
        if (sHandler.isLoggable(2) == false) goto L6;
        sHandler.v(r100, formatString(r101, new Object[]{r102, r103, r104, r105}));
        return;
    }
}

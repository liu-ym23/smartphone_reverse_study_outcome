package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes5.dex */
public class Logger {
    private static final String TAG = "Logger";
    static int mLevel = 4;

    public Logger() {
    }

    public static void d(String r100, String r101) {
    }

    public static void d(String r100, String r101, Throwable r102) {
    }

    public static void e(String r100, String r101) {
    }

    public static void e(String r100, String r101, Throwable r102) {
    }

    public static void i(String r100, String r101) {
    }

    public static void i(String r100, String r101, Throwable r102) {
    }

    public static void v(String r100, String r101) {
    }

    public static void v(String r100, String r101, Throwable r102) {
    }

    public static void w(String r100, String r101) {
    }

    public static void w(String r100, String r101, Throwable r102) {
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static void alertErrorInfo(String r100) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }

    public static void d(String r100) {
        d(TAG, r100);
    }

    public static void e(String r100) {
        e(TAG, r100);
    }

    private static String getSimpleClassName(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 >= 0) goto L6;
        return r100;
    L6:
        return r100.substring(r101 + 1);
    }

    public static void i(String r100) {
        i(TAG, r100);
    }

    public static void setLogLevel(int r100) {
        mLevel = r100;
    }

    public static void throwException(Throwable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r100);
    }

    public static void v(String r100) {
        v(TAG, r100);
    }

    public static void w(String r100) {
        w(TAG, r100);
    }

    public static void st(String r100, int r101) {
    L4:
        e = move-exception;
        StackTraceElement[] r102 = e.getStackTrace();
        StringBuilder r103 = new StringBuilder();
        int r104 = 1;
    L7:
        if (r104 >= Math.min(r101, r102.length)) goto L11;
        if (r104 <= 1) goto L10;
        r103.append("\n");
    L10:
        r103.append(getSimpleClassName(r102[r104].getClassName()));
        r103.append(".");
        r103.append(r102[r104].getMethodName());
        r104 = r104 + 1;
        goto L7
    L11:
        v(r100, r103.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }
}

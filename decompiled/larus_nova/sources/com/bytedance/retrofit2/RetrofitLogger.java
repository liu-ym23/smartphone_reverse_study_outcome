package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitLogger {
    private static final String TAG = "Logger";
    static int mLevel = 4;
    static ILogWritter sLogWritter;

    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class ILogWritter {
        public ILogWritter() {
        }

        public void logE(String r100, String r101) {
        }

        public void logE(String r100, String r101, Throwable r102) {
        }

        public void logI(String r100, String r101) {
        }

        public void logI(String r100, String r101, Throwable r102) {
        }

        public void logK(String r100, String r101) {
        }

        public void logW(String r100, String r101) {
        }

        public void logW(String r100, String r101, Throwable r102) {
        }
    }

    public RetrofitLogger() {
    }

    public static void d(String r100, String r101) {
    }

    public static void d(String r100, String r101, Throwable r102) {
    }

    public static void v(String r100, String r101) {
    }

    public static void v(String r100, String r101, Throwable r102) {
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

    public static void k(String r100) {
        k(TAG, r100);
    }

    public static void registerLogHandler(ILogWritter r100) {
        sLogWritter = r100;
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

    public static void e(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L8;
        r102.logE(r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L8;
        r102.logI(r100, r101);
        return;
    }

    public static void k(String r100, String r101) {
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L6;
        r102.logK(r100, r101);
        return;
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

    public static void w(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L8;
        r102.logW(r100, r101);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
        return;
    L5:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L9;
        r103.logE(r100, r101, r102);
        return;
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
        return;
    L5:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L9;
        r103.logI(r100, r101, r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
        return;
    L5:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L9;
        r103.logW(r100, r101, r102);
        return;
    }
}

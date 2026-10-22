package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static ILogWritter sLogWriter;

    /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class DefaultLogHandler extends ILogWritter {

        public static class SingletonHolder {
            private static final DefaultLogHandler INSTANCE = null;

            static {
                INSTANCE = new DefaultLogHandler(null);
            }

            public static /* synthetic */ DefaultLogHandler access$000() {
                return INSTANCE;
            }
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logD(String r100, String r101) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logD(String r100, String r101, Throwable r102) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logE(String r100, String r101) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logE(String r100, String r101, Throwable r102) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logI(String r100, String r101) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logI(String r100, String r101, Throwable r102) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logV(String r100, String r101) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logV(String r100, String r101, Throwable r102) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logW(String r100, String r101) {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logW(String r100, String r101, Throwable r102) {
        }

        public static DefaultLogHandler getInstance() {
            return SingletonHolder.access$000();
        }

        private DefaultLogHandler() {
        }

        public /* synthetic */ DefaultLogHandler(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ILogWritter {
        public ILogWritter() {
        }

        public abstract void logD(String r100, String r101);

        public abstract void logD(String r100, String r101, Throwable r102);

        public abstract void logE(String r100, String r101);

        public abstract void logE(String r100, String r101, Throwable r102);

        public abstract void logI(String r100, String r101);

        public abstract void logI(String r100, String r101, Throwable r102);

        public void logK(String r100, String r101) {
        }

        public abstract void logV(String r100, String r101);

        public abstract void logV(String r100, String r101, Throwable r102);

        public abstract void logW(String r100, String r101);

        public abstract void logW(String r100, String r101, Throwable r102);

        public boolean isLoggable(int r100) {
            if (Logger.getLogLevel() > r100) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Logger() {
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        sLogWriter = DefaultLogHandler.getInstance();
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
        sLogWriter = r100;
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

    public static void d(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(3) == false) goto L8;
        sLogWriter.logD(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(6) == false) goto L8;
        sLogWriter.logE(r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(4) == false) goto L8;
        sLogWriter.logI(r100, r101);
        return;
    }

    public static void k(String r100, String r101) {
        if (sLogWriter.isLoggable(3) == false) goto L6;
        sLogWriter.logK(r100, r101);
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

    public static void v(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(2) == false) goto L8;
        sLogWriter.logV(r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(5) == false) goto L8;
        sLogWriter.logW(r100, r101);
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(3) == false) goto L9;
        sLogWriter.logD(r100, r101, r102);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(6) == false) goto L9;
        sLogWriter.logE(r100, r101, r102);
        return;
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(4) == false) goto L9;
        sLogWriter.logI(r100, r101, r102);
        return;
    }

    public static void v(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(2) == false) goto L9;
        sLogWriter.logV(r100, r101, r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(5) == false) goto L9;
        sLogWriter.logW(r100, r101, r102);
        return;
    }
}

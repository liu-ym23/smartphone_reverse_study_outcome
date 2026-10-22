package android.ss.com.vboost.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class LogUtil {
    public static final int DEBUG = 3;
    private static final boolean DEVELOP_DEBUG = false;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static boolean LOG_DEBUG = false;
    private static volatile c<Integer> MAX_LOG_LEVEL_LAZY = null;
    private static final String PRE_TAG = "vboost";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static volatile ILog mLogOutput;

    public static class DefaultLog implements ILog {
        public DefaultLog() {
        }

        @Override // android.ss.com.vboost.utils.LogUtil.ILog
        public void vboostLog(int r1, String r2, String r3) {
        }
    }

    public interface ILog {
        void vboostLog(int r1, String r2, String r3);
    }

    static {
        mLogOutput = new DefaultLog();
        MAX_LOG_LEVEL_LAZY = new AnonymousClass1();
    }

    public LogUtil() {
    }

    public static void debug(String r3, String r4) {
        if (isLoggable(3) == false) goto L6;
        mLogOutput.vboostLog(3, "vboost:" + r3, getMsgFormat(r4));
        return;
    }

    public static void error(String r3, String r4) {
        if (isLoggable(6) == false) goto L6;
        mLogOutput.vboostLog(6, "vboost:" + r3, getMsgFormat(r4));
        return;
    }

    private static String getFunctionName() {
        StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r0 == null) goto L17;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L24;
        StackTraceElement r3 = r0[r2];
        if (r3.isNativeMethod() == true) goto L14;
        if (r3.getClassName().equals(Thread.class.getName()) == true) goto L14;
        if (r3.getClassName().equals(LogUtil.class.getName()) == true) goto L14;
        return "[ Thread:" + ThreadMethodProxy.currentThread().getName() + ", at " + r3.getClassName() + "." + r3.getMethodName() + "(" + r3.getFileName() + ":" + r3.getLineNumber() + ") ]";
    L14:
        r2 = r2 + 1;
        goto L5
    L24:
        return null;
    L17:
        return null;
    }

    private static String getMsgFormat(String r0) {
        return r0;
    }

    public static void info(String r3, String r4) {
        if (isLoggable(4) == false) goto L6;
        mLogOutput.vboostLog(4, "vboost:" + r3, getMsgFormat(r4));
        return;
    }

    private static boolean isLoggable(int r1) {
        if (LOG_DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (r1 >= MAX_LOG_LEVEL_LAZY.get().intValue()) goto L8;
        return false;
    }

    public static void register(ILog r1) {
        LOG_DEBUG = true;
        if (r1 != null) goto L6;
        r1 = new DefaultLog();
    L6:
        mLogOutput = r1;
    }

    public static void setLogLevel(int r1) {
        MAX_LOG_LEVEL_LAZY.set(Integer.valueOf(r1));
        LOG_DEBUG = true;
    }

    public static void verbose(String r3, String r4) {
        if (isLoggable(2) == false) goto L6;
        mLogOutput.vboostLog(2, "vboost:" + r3, getMsgFormat(r4));
        return;
    }

    public static void warn(String r3, String r4) {
        if (isLoggable(5) == false) goto L6;
        mLogOutput.vboostLog(5, "vboost:" + r3, getMsgFormat(r4));
        return;
    }
}

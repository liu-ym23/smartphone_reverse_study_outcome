package com.ss.android.ttvecamera;

import android.util.Log;

/* JADX INFO: loaded from: classes38.dex */
public class TELogUtils {
    private static String APPNAME = "VESDK-";
    private static String AUTO_TEST_MONITOR = "monitorInfo";
    private static byte DEBUG_LEVEL = 7;
    public static final byte DEBUG_LEVEL_D = 15;
    public static final byte DEBUG_LEVEL_E = 1;
    public static final byte DEBUG_LEVEL_I = 7;
    public static final byte DEBUG_LEVEL_N = 0;
    public static final byte DEBUG_LEVEL_V = 31;
    public static final byte DEBUG_LEVEL_W = 3;
    public static final byte LOGD = 8;
    public static final byte LOGE = 1;
    public static final byte LOGI = 4;
    public static final byte LOGV = 16;
    public static final byte LOGW = 2;
    public static final boolean TEST_LOG_FLAG = false;
    private static volatile ILog mLogOutput;

    public static class DefaultLog implements ILog {
        public DefaultLog() {
        }

        @Override // com.ss.android.ttvecamera.TELogUtils.ILog
        public void Log(byte r100, String r101, String r102) {
        }
    }

    public interface ILog {
        void Log(byte r100, String r101, String r102);
    }

    public TELogUtils() {
    }

    public static int getAndroidLogLevel(byte r100) {
        if (r100 != 1) goto L5;
        return 6;
    L5:
        if (r100 != 3) goto L7;
        return 5;
    L7:
        if (r100 != 7) goto L9;
        return 4;
    L9:
        if (r100 != 15) goto L11;
        return 3;
    L11:
        if (r100 == 31) goto L14;
        return 0;
    L14:
        return 2;
    }

    public static byte getLogLevel(int r100) {
        if (r100 != 2) goto L5;
        return 31;
    L5:
        if (r100 != 3) goto L7;
        return 15;
    L7:
        if (r100 != 4) goto L9;
        return 7;
    L9:
        if (r100 != 5) goto L11;
        return 3;
    L11:
        if (r100 == 6) goto L14;
        return 0;
    L14:
        return 1;
    }

    static {
        mLogOutput = new DefaultLog();
    }

    public static String getStackTraceString() {
        return Log.getStackTraceString(new Throwable());
    }

    public static void printStackTrace() {
        d("Debug", getStackTraceString());
    }

    public static byte getLogLevel() {
        return DEBUG_LEVEL;
    }

    public static void register(ILog r100) {
        if (r100 == null) goto L4;
        mLogOutput = r100;
        return;
    L4:
        mLogOutput = new DefaultLog();
    }

    public static void d(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        mLogOutput.Log((byte) 8, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void e(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        mLogOutput.Log((byte) 1, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void i(String r100, String r101) {
        if ((DEBUG_LEVEL & 4) == 0) goto L6;
        mLogOutput.Log((byte) 4, APPNAME + r100, r101);
        return;
    }

    public static void logMonitorInfo(String r100, Object r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        r101.toString();
        return;
    }

    public static void setUp(String r100, byte r101) {
        if (r100 != null) goto L4;
    L6:
        DEBUG_LEVEL = r101;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        APPNAME = r100.concat("-");
        goto L6
    }

    public static void v(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 16) == 0) goto L6;
        mLogOutput.Log((byte) 16, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void w(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        mLogOutput.Log((byte) 2, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void d(String r100, String r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        mLogOutput.Log((byte) 8, APPNAME + r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        mLogOutput.Log((byte) 1, APPNAME + r100, r101);
        return;
    }

    public static void setUp(String r100, int r101) {
        setUp(r100, getLogLevel(r101));
    }

    public static void v(String r100, String r101) {
        if ((DEBUG_LEVEL & 16) == 0) goto L6;
        mLogOutput.Log((byte) 16, APPNAME + r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        mLogOutput.Log((byte) 2, APPNAME + r100, r101);
        return;
    }

    public static void e(Class<?> r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        String r103 = APPNAME + r100.getSimpleName();
        mLogOutput.Log((byte) 1, r103, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static void w(Class<?> r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        String r103 = APPNAME + r100.getSimpleName();
        mLogOutput.Log((byte) 2, r103, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        String r103 = APPNAME + r100;
        mLogOutput.Log((byte) 1, r103, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        String r103 = APPNAME + r100;
        mLogOutput.Log((byte) 2, r103, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }
}

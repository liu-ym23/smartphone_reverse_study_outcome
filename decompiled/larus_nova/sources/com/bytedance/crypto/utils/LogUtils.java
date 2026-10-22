package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.ILogBridge;

/* JADX INFO: loaded from: classes6.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;
    private static ILogBridge mLogBridge;

    static {
        LOG_DEBUG = CryptoConfig.isDebug();
    }

    public LogUtils() {
    }

    public static void d(String r100, String r101) {
        if (LOG_DEBUG == false) goto L8;
        ILogBridge r102 = mLogBridge;
        if (r102 == null) goto L9;
        r102.i(r100, r101);
        return;
    L9:
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (LOG_DEBUG == false) goto L8;
        ILogBridge r103 = mLogBridge;
        if (r103 == null) goto L9;
        r103.i(r100, r101);
        return;
    L9:
        return;
    }

    public static void e(String r100, String r101) {
        ILogBridge r102 = mLogBridge;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        ILogBridge r103 = mLogBridge;
        if (r103 == null) goto L6;
        r103.e(r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        ILogBridge r102 = mLogBridge;
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    public static void i(String r100, String r101, Throwable r102) {
        ILogBridge r103 = mLogBridge;
        if (r103 == null) goto L6;
        r103.i(r100, r101);
        return;
    }

    public static void init(ILogBridge r100) {
        mLogBridge = r100;
    }

    public static void w(String r100, String r101) {
        ILogBridge r102 = mLogBridge;
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }
}

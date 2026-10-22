package com.relax.embedding;

import android.content.Context;
import i6a.a;

/* JADX INFO: loaded from: classes34.dex */
public class LLog {
    private static int LOG_LEVEL_DEBUG = 1;
    private static int LOG_LEVEL_ERROR = 4;
    private static int LOG_LEVEL_FATAL = 5;
    private static int LOG_LEVEL_INFO = 2;
    private static int LOG_LEVEL_VERBOSE = 0;
    private static int LOG_LEVEL_WARNING = 3;
    private static String RELAX_TAG = "relax";
    private static boolean alogEnable;
    private static long alogNativePtr;
    private static int sALogMinLogLevel;

    public LLog() {
    }

    private static native void nativeInitALogNative(long r100);

    private static native void nativeInternalLog(int r100, String r101, String r102);

    static {
        if (a.f488445a.booleanValue() == false) goto L5;
        int r100 = LOG_LEVEL_DEBUG;
    L6:
        sALogMinLogLevel = r100;
        return;
    L5:
        r100 = LOG_LEVEL_INFO;
        goto L6
    }

    public static void Initialize(Context r100) {
        long r101 = ((Long) ipa.a.a().getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        alogNativePtr = r101;     // Catch: Throwable -> L5
        if (r101 == 0) goto L18;
        alogEnable = true;     // Catch: Throwable -> L5
        nativeInitALogNative(r101);     // Catch: Throwable -> L5
        return;
    L18:
        return;
    L7:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L5
        r101 = 0;
    L5:
        th = move-exception;
        th.getMessage();
    }

    public static void d(String r100) {
        int r101 = sALogMinLogLevel;
        int r102 = LOG_LEVEL_DEBUG;
        if (r101 <= r102) goto L5;
        return;
    L5:
        if (alogEnable == false) goto L9;
        nativeInternalLog(r102, RELAX_TAG, r100);
        return;
    }

    public static void e(String r100) {
        if (sALogMinLogLevel <= LOG_LEVEL_WARNING) goto L5;
        return;
    L5:
        if (alogEnable == false) goto L9;
        nativeInternalLog(LOG_LEVEL_ERROR, RELAX_TAG, r100);
        return;
    }

    public static void i(String r100) {
        int r101 = sALogMinLogLevel;
        int r102 = LOG_LEVEL_INFO;
        if (r101 <= r102) goto L5;
        return;
    L5:
        if (alogEnable == false) goto L9;
        nativeInternalLog(r102, RELAX_TAG, r100);
        return;
    }

    public static void setMinimumLoggingLevel(int r100) {
        sALogMinLogLevel = r100;
    }

    public static void v(String r100) {
        int r101 = sALogMinLogLevel;
        int r102 = LOG_LEVEL_VERBOSE;
        if (r101 <= r102) goto L5;
        return;
    L5:
        if (alogEnable == false) goto L9;
        nativeInternalLog(r102, RELAX_TAG, r100);
        return;
    }

    public static void w(String r100) {
        int r101 = sALogMinLogLevel;
        int r102 = LOG_LEVEL_WARNING;
        if (r101 <= r102) goto L5;
        return;
    L5:
        if (alogEnable == false) goto L9;
        nativeInternalLog(r102, RELAX_TAG, r100);
        return;
    }
}

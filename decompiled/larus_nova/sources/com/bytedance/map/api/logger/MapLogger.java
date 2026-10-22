package com.bytedance.map.api.logger;

import android.util.Log;

/* JADX INFO: loaded from: classes21.dex */
public class MapLogger {
    public static final String TAG = "BDMapView";
    private static volatile ILogger sLogger;

    public MapLogger() {
    }

    private static ILogger createDefaultLogger() {
        return new ALogger();
    L5:
        return new AnonymousClass1();
    }

    static {
        sLogger = createDefaultLogger();
    }

    public static void d(String r100) {
        if (sLogger == null) goto L6;
        sLogger.d(r100);
        return;
    }

    public static void e(String r100) {
        if (sLogger == null) goto L6;
        sLogger.e(r100);
        return;
    }

    public static void i(String r100) {
        if (sLogger == null) goto L6;
        sLogger.i(r100);
        return;
    }

    public static void setLogger(ILogger r100) {
        if (r100 == null) goto L5;
        sLogger = r100;
        return;
    }

    public static void v(String r100) {
        if (sLogger == null) goto L6;
        sLogger.v(r100);
        return;
    }

    public static void w(String r100) {
        if (sLogger == null) goto L6;
        sLogger.w(r100);
        return;
    }

    private static String appendThrowable(String r100, Throwable r101) {
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 + '\n' + Log.getStackTraceString(r101);
    }

    private static String buildMessage(String r100, String r101) {
        if (r100 != null) goto L4;
    L8:
        return r101;
    L4:
        if (r100.isEmpty() == true) goto L8;
        return r100 + ": " + r101;
    }

    public static void d(String r100, String r101) {
        d(buildMessage(r100, r101));
    }

    public static void e(String r100, String r101) {
        e(buildMessage(r100, r101));
    }

    public static void i(String r100, String r101) {
        i(buildMessage(r100, r101));
    }

    public static void v(String r100, String r101) {
        v(buildMessage(r100, r101));
    }

    public static void w(String r100, String r101) {
        w(buildMessage(r100, r101));
    }

    public static void d(String r100, String r101, Throwable r102) {
        d(buildMessage(r100, appendThrowable(r101, r102)));
    }

    public static void e(String r100, String r101, Throwable r102) {
        e(buildMessage(r100, appendThrowable(r101, r102)));
    }

    public static void i(String r100, String r101, Throwable r102) {
        i(buildMessage(r100, appendThrowable(r101, r102)));
    }

    public static void v(String r100, String r101, Throwable r102) {
        v(buildMessage(r100, appendThrowable(r101, r102)));
    }

    public static void w(String r100, String r101, Throwable r102) {
        w(buildMessage(r100, appendThrowable(r101, r102)));
    }
}

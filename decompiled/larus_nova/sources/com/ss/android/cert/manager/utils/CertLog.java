package com.ss.android.cert.manager.utils;

import android.util.Log;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class CertLog {
    private static final String TAG = "CertLog";

    public CertLog() {
    }

    public static String getStackTraceString(Throwable r100) {
        return Log.getStackTraceString(r100);
    }

    public static void d(String r100, String r101) {
        Logger.d(r100, r101);
    }

    public static void e(String r100, String r101) {
        Logger.e(r100, r101);
    }

    public static void i(String r100, String r101) {
        Logger.i(r100, r101);
    }

    public static void v(String r100, String r101) {
        Logger.v(r100, r101);
    }

    public static void w(String r100, String r101) {
        Logger.w(r100, r101);
    }

    public static void e(String r100, String r101, Throwable r102) {
        Logger.e(r100, r101, r102);
    }

    public static void w(String r100, String r101, Throwable r102) {
        Logger.w(r100, r101, r102);
    }
}

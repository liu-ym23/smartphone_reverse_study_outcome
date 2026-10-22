package com.bytedance.unitm.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes22.dex */
public class TLog {
    private static final String TAG = "unitm";
    public static boolean sDebug;

    public TLog() {
    }

    public static void d(String r100, String r101) {
    }

    public static void e(String r100, String r101) {
    }

    public static void i(String r100, String r101) {
    }

    public static void v(String r100, String r101) {
    }

    public static void w(String r100, String r101) {
    }

    static {
        sDebug = Log.isLoggable(TAG, 3);
    }

    public static void d(String r100) {
        d(TAG, r100);
    }

    public static void e(String r100) {
        e(TAG, r100);
    }

    public static void i(String r100) {
        i(TAG, r100);
    }

    public static void v(String r100) {
        v(TAG, r100);
    }

    public static void w(String r100) {
        w(TAG, r100);
    }

    public static void toast(Context r100, String r101) {
        Toast.makeText(r100, r101, 1).show();
    }
}

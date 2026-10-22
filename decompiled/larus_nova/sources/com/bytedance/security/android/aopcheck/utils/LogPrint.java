package com.bytedance.security.android.aopcheck.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes3.dex */
public class LogPrint {
    public static String TAG = "SecurityAOPCheck";

    public LogPrint() {
    }

    public static final void d(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ALog.d(TAG, r100);
        return;
    }

    public static final void e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ALog.e(TAG, r100);
        return;
    }

    public static final void i(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ALog.i(TAG, r100);
        return;
    }

    public static void printInterfaces(Object r100) {
        Class<?>[] r101 = r100.getClass().getInterfaces();
        int r102 = 0;
    L10:
    L7:
        th = move-exception;
        printStackTrace(th);
        return;
    L4:
        if (r102 >= r101.length) goto L13;
        ALog.i(TAG, r100.getClass().getName() + ":interface " + r102 + ":" + r101[r102].getName());     // Catch: Throwable -> L7
        r102 = r102 + 1;
        goto L10
    }

    public static void printStackTrace(Throwable r100) {
        ALog.e(TAG, Log.getStackTraceString(r100));
    }

    public static final void w(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ALog.w(TAG, r100);
        return;
    }
}

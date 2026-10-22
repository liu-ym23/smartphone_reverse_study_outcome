package com.bytedance.android.alog;

import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
class NativeCallback {
    public NativeCallback() {
    }

    public static void onNativeDeleteLog(String r0, long r1, int r3) {
        ALog.notifyLogFileDelete(r0, r1, r3);     // Catch: Throwable -> L4
        return;
    }
}

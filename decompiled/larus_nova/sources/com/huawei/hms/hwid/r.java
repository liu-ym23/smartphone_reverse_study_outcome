package com.huawei.hms.hwid;

import android.os.Looper;

/* JADX INFO: loaded from: classes23.dex */
public class r {
    public static void a() {
        a("Must not be called on the main application thread");
    }

    public static void a(String r100) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }
}

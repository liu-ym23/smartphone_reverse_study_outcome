package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class KGetCookieOptimizer {
    private static final String TAG = "KGetCookieOptimizer";
    private static boolean sOptimized;

    public KGetCookieOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(KGetCookieOptimizer.class);
        if (sOptimized == false) goto L8;
        monitor-exit(KGetCookieOptimizer.class);
        return;
    L8:
        monitor-exit(KGetCookieOptimizer.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

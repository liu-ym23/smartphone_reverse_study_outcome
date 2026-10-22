package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class DvmGlesOptimizer {
    private static final String TAG = "DvmGlesOptimizer";
    private static boolean mOptimized;

    public DvmGlesOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(DvmGlesOptimizer.class);
        if (mOptimized == false) goto L8;
        monitor-exit(DvmGlesOptimizer.class);
        return;
    L8:
        monitor-exit(DvmGlesOptimizer.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

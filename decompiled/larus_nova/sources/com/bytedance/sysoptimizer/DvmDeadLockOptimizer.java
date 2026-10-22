package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized;

    private DvmDeadLockOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        return false;
    }

    private static native boolean optimize();

    public static synchronized boolean optimize(Context r100) {
        monitor-enter(DvmDeadLockOptimizer.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(DvmDeadLockOptimizer.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r100) == true) goto L21;
    L14:
        monitor-exit(DvmDeadLockOptimizer.class);
        return false;
    L21:
        boolean r101 = optimize();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        mOptimized = r101;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        monitor-exit(DvmDeadLockOptimizer.class);
        return r101;
        goto L14
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class DvmOptimizer {
    private static boolean sOptimized;

    private DvmOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        return false;
    }

    private static native void optLinearAllocBuffer(int r100);

    private static native void startHookDvmFunc();

    public static void hookDvmLinearAllocFunc(Context r100) {
        if (loadOptimizerOnNeed(r100) == false) goto L6;
        startHookDvmFunc();
        return;
    }

    public static void optDvmLinearAllocBuffer(Context r100) {
        optDvmLinearAllocBuffer(r100, 67108864);
    }

    public static synchronized void optDvmLinearAllocBuffer(Context r100, int r101) {
        monitor-enter(DvmOptimizer.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L9;
        monitor-exit(DvmOptimizer.class);
        return;
    L9:
        if (loadOptimizerOnNeed(r100) == false) goto L11;
        optLinearAllocBuffer(r101);     // Catch: Throwable -> L13
        sOptimized = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(DvmOptimizer.class);
    }
}

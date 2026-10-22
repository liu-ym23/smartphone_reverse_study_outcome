package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* JADX INFO: loaded from: classes22.dex */
public class CfiCheckOptimizer {
    private static final String TAG = "CfiCheckOptimizer";
    private static boolean mOptimized;

    private CfiCheckOptimizer() {
    }

    private static native boolean disableCfiCheck();

    private static boolean loadOptimizerOnNeed(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 29) goto L5;
        return false;
    L5:
        if (r101 <= 30) goto L7;
        return false;
    L7:
        if (Process.is64Bit() == true) goto L10;
        return false;
    L10:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized boolean optimize(Context r100) {
        monitor-enter(CfiCheckOptimizer.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(CfiCheckOptimizer.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r100) == true) goto L21;
    L14:
        monitor-exit(CfiCheckOptimizer.class);
        return false;
    L21:
        boolean r101 = disableCfiCheck();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        mOptimized = r101;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        monitor-exit(CfiCheckOptimizer.class);
        return r101;
        goto L14
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class HighLevelTrimMemory {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized;

    private HighLevelTrimMemory() {
    }

    private static native boolean disable();

    private static boolean loadOptimizerOnNeed(Context r100) {
        if (Build.VERSION.SDK_INT <= 29) goto L7;
        return false;
    L7:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized boolean optimize(Context r100) {
        monitor-enter(HighLevelTrimMemory.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(HighLevelTrimMemory.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r100) == true) goto L21;
    L14:
        monitor-exit(HighLevelTrimMemory.class);
        return false;
    L21:
        boolean r101 = disable();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        mOptimized = r101;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        monitor-exit(HighLevelTrimMemory.class);
        return r101;
        goto L14
    }
}

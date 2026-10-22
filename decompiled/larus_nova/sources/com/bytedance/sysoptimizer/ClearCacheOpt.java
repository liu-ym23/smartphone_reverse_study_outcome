package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class ClearCacheOpt {
    private static final String TAG = "ClearCacheOpt";
    private static boolean sOptimized;

    public ClearCacheOpt() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(ClearCacheOpt.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L9;
        monitor-exit(ClearCacheOpt.class);
        return;
    L9:
        if (Build.VERSION.SDK_INT == 24) goto L11;
    L13:
        monitor-exit(ClearCacheOpt.class);
        return;
    L11:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L13;
        optimize();     // Catch: Throwable -> L18 Throwable -> L15
        optimize();     // Catch: Throwable -> L18 Throwable -> L15
        sOptimized = true;     // Catch: Throwable -> L18 Throwable -> L15
        goto L13
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class NougatJitCompileOptimizer {
    private static final String TAG = "NJitCompileOptimizer";
    private static boolean sOptimized;

    public NougatJitCompileOptimizer() {
    }

    private static native void optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(NougatJitCompileOptimizer.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L10;
        monitor-exit(NougatJitCompileOptimizer.class);
        return;
    L10:
        if (Build.VERSION.SDK_INT == 24) goto L14;
        monitor-exit(NougatJitCompileOptimizer.class);
        return;
    L14:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L22;
    L16:
        monitor-exit(NougatJitCompileOptimizer.class);
        return;
    L22:
        optimize();     // Catch: Throwable -> L21 Throwable -> L18
        sOptimized = true;     // Catch: Throwable -> L21 Throwable -> L18
        goto L16
    }
}

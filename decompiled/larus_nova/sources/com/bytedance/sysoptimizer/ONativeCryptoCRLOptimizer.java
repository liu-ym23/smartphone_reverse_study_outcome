package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public class ONativeCryptoCRLOptimizer {
    private static final String TAG = "NativeCrypt";
    private static boolean sOptimized;

    public ONativeCryptoCRLOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(ONativeCryptoCRLOptimizer.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(ONativeCryptoCRLOptimizer.class);
        return;
    L8:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17
        if (r101 == 27) goto L13;
        if (r101 == 26) goto L13;
    L15:
        monitor-exit(ONativeCryptoCRLOptimizer.class);
        return;
    L13:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L15;
        optimize();     // Catch: Throwable -> L20 Throwable -> L17
        sOptimized = true;     // Catch: Throwable -> L20 Throwable -> L17
        goto L15
    }
}

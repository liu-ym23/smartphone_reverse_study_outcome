package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class NterpOpt {
    private static final String TAG = "NterpOpt";
    private static boolean sOptimized;

    public NterpOpt() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(NterpOpt.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(NterpOpt.class);
        return;
    L8:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17
        if (r101 >= 31) goto L11;
    L15:
        monitor-exit(NterpOpt.class);
        return;
    L11:
        if (r101 > 33) goto L15;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L15;
        optimize();     // Catch: Throwable -> L20 Throwable -> L17
        sOptimized = true;     // Catch: Throwable -> L20 Throwable -> L17
        goto L15
    }
}

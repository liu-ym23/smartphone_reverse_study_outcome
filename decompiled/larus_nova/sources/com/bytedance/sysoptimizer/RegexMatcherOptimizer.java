package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class RegexMatcherOptimizer {
    private static final String TAG = "RegexMatcherOptimizer";
    private static boolean sOptimized;

    public RegexMatcherOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(RegexMatcherOptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(RegexMatcherOptimizer.class);
        return;
    L8:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L20
        if (r101 == 21) goto L16;
        if (r101 == 22) goto L16;
        monitor-exit(RegexMatcherOptimizer.class);
        return;
    L16:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L26;
    L18:
        monitor-exit(RegexMatcherOptimizer.class);
        return;
    L26:
        optimize();     // Catch: Throwable -> L23 Throwable -> L20
        optimize();     // Catch: Throwable -> L23 Throwable -> L20
        sOptimized = true;     // Catch: Throwable -> L23 Throwable -> L20
        goto L18
    }
}

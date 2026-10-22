package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class JitCodeCacheShrinker {
    private static String TAG = "OPTIMIZER-JitCodeCacheShrinker";
    private static boolean mOptimized;

    public JitCodeCacheShrinker() {
    }

    private static native boolean native_shrink(int r100, int r101);

    private static boolean loadOptimizerOnNeed(Context r100) {
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized void shrink(Context r100, int r101) {
        monitor-enter(JitCodeCacheShrinker.class);
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L20
        if (r102 >= 29) goto L7;
    L18:
        monitor-exit(JitCodeCacheShrinker.class);
        return;
    L7:
        if (r102 > 33) goto L18;
        if (mOptimized == false) goto L14;
        monitor-exit(JitCodeCacheShrinker.class);
        return;
    L14:
        if (loadOptimizerOnNeed(r100) == true) goto L24;
    L16:
        monitor-exit(JitCodeCacheShrinker.class);
        return;
    L24:
        ByteHook.init();     // Catch: UnsatisfiedLinkError -> L23 Throwable -> L20
        mOptimized = native_shrink(r102, r101);     // Catch: UnsatisfiedLinkError -> L23 Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}

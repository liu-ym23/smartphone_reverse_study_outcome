package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class JitCompileMethodCrash {
    private static String TAG = "OPTIMIZER-JIT";
    private static boolean mOptimized;

    private JitCompileMethodCrash() {
    }

    private static native boolean optimize(int r100);

    private static boolean loadOptimizerOnNeed(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 26) goto L5;
        return false;
    L5:
        if (r101 <= 31) goto L8;
        return false;
    L8:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized boolean optimize(Context r100) {
        monitor-enter(JitCompileMethodCrash.class);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (mOptimized == false) goto L11;
        monitor-exit(JitCompileMethodCrash.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r100) == true) goto L23;
    L15:
        monitor-exit(JitCompileMethodCrash.class);
        return false;
    L23:
        ShadowHook.access$000();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        ShadowHook.access$100();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        r102.f270294a = r101;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        r102.f270295b = true;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        r102.f270296c = false;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        r102.f270297d = false;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        ShadowHook.init(r102);     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        boolean r103 = optimize(Build.VERSION.SDK_INT);     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        mOptimized = r103;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        monitor-exit(JitCompileMethodCrash.class);
        return r103;
        goto L15
    }
}

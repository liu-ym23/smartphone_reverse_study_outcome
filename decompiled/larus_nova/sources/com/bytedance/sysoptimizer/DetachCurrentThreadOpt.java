package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class DetachCurrentThreadOpt {
    private static final String TAG = "DetachCurrentThreadOpt";
    private static boolean sOptimized;

    public DetachCurrentThreadOpt() {
    }

    private static native boolean optimize();

    private static boolean isTargetOSVersion() {
        if (Build.VERSION.SDK_INT > 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void fix(Context r100) {
        monitor-enter(DetachCurrentThreadOpt.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L9;
        monitor-exit(DetachCurrentThreadOpt.class);
        return;
    L9:
        if (isTargetOSVersion() == true) goto L13;
        monitor-exit(DetachCurrentThreadOpt.class);
        return;
    L13:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L16;
        ShadowHook.access$000();     // Catch: Throwable -> L18
        ShadowHook.access$100();     // Catch: Throwable -> L18
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L18
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L18
        r102.f270294a = r101;     // Catch: Throwable -> L18
        r102.f270295b = true;     // Catch: Throwable -> L18
        r102.f270296c = false;     // Catch: Throwable -> L18
        r102.f270297d = false;     // Catch: Throwable -> L18
        ShadowHook.init(r102);     // Catch: Throwable -> L18
        optimize();     // Catch: Throwable -> L21 Throwable -> L18
        sOptimized = true;     // Catch: Throwable -> L21 Throwable -> L18
    L16:
        monitor-exit(DetachCurrentThreadOpt.class);
    }

    public static void fix(Context r100, int r101) {
        fix(r100);
    }
}

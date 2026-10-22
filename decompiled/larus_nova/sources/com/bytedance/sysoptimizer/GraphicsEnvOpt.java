package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class GraphicsEnvOpt {
    private static final String TAG = "GraphicsEnvOpt";
    private static boolean sOptimized;

    public GraphicsEnvOpt() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(GraphicsEnvOpt.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L10;
        monitor-exit(GraphicsEnvOpt.class);
        return;
    L10:
        if (Build.VERSION.SDK_INT == 29) goto L14;
        monitor-exit(GraphicsEnvOpt.class);
        return;
    L14:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L17;
        ShadowHook.access$000();     // Catch: Throwable -> L19
        ShadowHook.access$100();     // Catch: Throwable -> L19
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L19
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L19
        r102.f270294a = r101;     // Catch: Throwable -> L19
        r102.f270295b = true;     // Catch: Throwable -> L19
        r102.f270296c = false;     // Catch: Throwable -> L19
        r102.f270297d = false;     // Catch: Throwable -> L19
        ShadowHook.init(r102);     // Catch: Throwable -> L19
        optimize();     // Catch: Throwable -> L22 Throwable -> L19
        sOptimized = true;     // Catch: Throwable -> L22 Throwable -> L19
    L17:
        monitor-exit(GraphicsEnvOpt.class);
    }
}

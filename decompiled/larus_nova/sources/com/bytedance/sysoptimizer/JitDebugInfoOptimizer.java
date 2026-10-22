package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class JitDebugInfoOptimizer {
    private static final String TAG = "JitDebugInfoOptimizer";
    private static volatile boolean isOptimized;

    public JitDebugInfoOptimizer() {
    }

    private static native void doOptimize(int r100, boolean r101);

    public static synchronized void install(Context r100, boolean r101) {
        monitor-enter(JitDebugInfoOptimizer.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isOptimized == true) goto L11;
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L13
        if (r102 < 28) goto L11;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        ShadowHook.access$000();     // Catch: Throwable -> L13
        ShadowHook.access$100();     // Catch: Throwable -> L13
        int r103 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L13
        ShadowHook.b r104 = new ShadowHook.b();     // Catch: Throwable -> L13
        r104.f270294a = r103;     // Catch: Throwable -> L13
        r104.f270295b = true;     // Catch: Throwable -> L13
        r104.f270296c = false;     // Catch: Throwable -> L13
        r104.f270297d = false;     // Catch: Throwable -> L13
        ShadowHook.init(r104);     // Catch: Throwable -> L13
        doOptimize(r102, r101);     // Catch: Throwable -> L13
        isOptimized = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(JitDebugInfoOptimizer.class);
    }
}

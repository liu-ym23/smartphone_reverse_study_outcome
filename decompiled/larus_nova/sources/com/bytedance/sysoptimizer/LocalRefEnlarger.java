package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class LocalRefEnlarger {
    private static final String TAG = "LocalRefEnlarger";
    private static boolean sOptimized;

    public LocalRefEnlarger() {
    }

    private static native boolean optimize(int r100);

    public static native void test();

    public static synchronized void fix(Context r100) {
        monitor-enter(LocalRefEnlarger.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(LocalRefEnlarger.class);
        return;
    L8:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L18
        if (r101 <= 26) goto L14;
        monitor-exit(LocalRefEnlarger.class);
        return;
    L14:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L22;
    L16:
        monitor-exit(LocalRefEnlarger.class);
        return;
    L22:
        ShadowHook.access$000();     // Catch: Throwable -> L21 Throwable -> L18
        ShadowHook.access$100();     // Catch: Throwable -> L21 Throwable -> L18
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L21 Throwable -> L18
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L21 Throwable -> L18
        r103.f270294a = r102;     // Catch: Throwable -> L21 Throwable -> L18
        r103.f270295b = true;     // Catch: Throwable -> L21 Throwable -> L18
        r103.f270296c = false;     // Catch: Throwable -> L21 Throwable -> L18
        r103.f270297d = false;     // Catch: Throwable -> L21 Throwable -> L18
        ShadowHook.init(r103);     // Catch: Throwable -> L21 Throwable -> L18
        optimize(r101);     // Catch: Throwable -> L21 Throwable -> L18
        sOptimized = true;     // Catch: Throwable -> L21 Throwable -> L18
        goto L16
    }
}

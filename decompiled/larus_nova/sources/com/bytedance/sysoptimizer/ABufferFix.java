package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class ABufferFix {
    private static final String TAG = "ABufferFix";
    private static boolean sOptimized;

    public ABufferFix() {
    }

    private static native boolean nStart(int r100, boolean r101, boolean r102, boolean r103);

    public static synchronized void start(Context r100, boolean r101, boolean r102, boolean r103) {
        monitor-enter(ABufferFix.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(ABufferFix.class);
        return;
    L8:
        int r104 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L12;
        ShadowHook.access$000();     // Catch: Throwable -> L14
        ShadowHook.access$100();     // Catch: Throwable -> L14
        int r105 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L14
        ShadowHook.b r106 = new ShadowHook.b();     // Catch: Throwable -> L14
        r106.f270294a = r105;     // Catch: Throwable -> L14
        r106.f270295b = true;     // Catch: Throwable -> L14
        r106.f270296c = false;     // Catch: Throwable -> L14
        r106.f270297d = false;     // Catch: Throwable -> L14
        ShadowHook.init(r106);     // Catch: Throwable -> L14
        nStart(r104, r101, r102, r103);     // Catch: Throwable -> L17 Throwable -> L14
        sOptimized = true;     // Catch: Throwable -> L17 Throwable -> L14
    L12:
        monitor-exit(ABufferFix.class);
    }
}

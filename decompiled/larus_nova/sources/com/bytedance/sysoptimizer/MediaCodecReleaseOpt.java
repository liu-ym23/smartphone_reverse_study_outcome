package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class MediaCodecReleaseOpt {
    private static final String TAG = "MediaCodecReleaseOpt";
    private static boolean sOptimized;

    public MediaCodecReleaseOpt() {
    }

    private static native boolean optimize(boolean r100);

    public static synchronized void fix(Context r100, boolean r101) {
        monitor-enter(MediaCodecReleaseOpt.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L9;
        monitor-exit(MediaCodecReleaseOpt.class);
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 30) goto L11;
    L14:
        monitor-exit(MediaCodecReleaseOpt.class);
        return;
    L11:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L14;
        ShadowHook.access$000();     // Catch: Throwable -> L16
        ShadowHook.access$100();     // Catch: Throwable -> L16
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L16
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L16
        r103.f270294a = r102;     // Catch: Throwable -> L16
        r103.f270295b = true;     // Catch: Throwable -> L16
        r103.f270296c = false;     // Catch: Throwable -> L16
        r103.f270297d = false;     // Catch: Throwable -> L16
        ShadowHook.init(r103);     // Catch: Throwable -> L16
        optimize(r101);     // Catch: Throwable -> L19 Throwable -> L16
        sOptimized = true;     // Catch: Throwable -> L19 Throwable -> L16
        goto L14
    }
}

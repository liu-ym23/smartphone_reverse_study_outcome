package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class BypassDexFileVerify {
    private static final String TAG = "BypassDexFileVerify";
    private static boolean sInited;

    public BypassDexFileVerify() {
    }

    private static native int bypassVerifyNative();

    private static boolean isTargetOSVersion() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 27) goto L7;
        return true;
    }

    public static synchronized int bypassVerify(Context r100) {
        monitor-enter(BypassDexFileVerify.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        int r101 = -1;
        if (sInited == false) goto L10;
        monitor-exit(BypassDexFileVerify.class);
        return -1;
    L10:
        if (isTargetOSVersion() == true) goto L14;
        monitor-exit(BypassDexFileVerify.class);
        return -1;
    L14:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L17;
        ShadowHook.access$000();     // Catch: Throwable -> L19
        ShadowHook.access$100();     // Catch: Throwable -> L19
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L19
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L19
        r103.f270294a = r102;     // Catch: Throwable -> L19
        r103.f270295b = true;     // Catch: Throwable -> L19
        r103.f270296c = false;     // Catch: Throwable -> L19
        r103.f270297d = false;     // Catch: Throwable -> L19
        ShadowHook.init(r103);     // Catch: Throwable -> L19
        r101 = bypassVerifyNative();     // Catch: Throwable -> L22 Throwable -> L19
        sInited = true;     // Catch: Throwable -> L22 Throwable -> L19
    L17:
        monitor-exit(BypassDexFileVerify.class);
        return r101;
    }
}

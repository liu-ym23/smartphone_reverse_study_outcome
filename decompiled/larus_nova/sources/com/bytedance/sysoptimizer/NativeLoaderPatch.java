package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class NativeLoaderPatch {
    private static final String TAG = "NativeLoaderPatch";

    public NativeLoaderPatch() {
    }

    private static native boolean applyNative();

    public static boolean apply(Context r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L14;
        return false;
    L14:
    L13:
        return false;
    L6:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L8;
        return false;
    L8:
        ShadowHook.access$000();     // Catch: Throwable -> L13
        ShadowHook.access$100();     // Catch: Throwable -> L13
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L13
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L13
        r102.f270294a = r101;     // Catch: Throwable -> L13
        r102.f270295b = true;     // Catch: Throwable -> L13
        r102.f270296c = false;     // Catch: Throwable -> L13
        r102.f270297d = false;     // Catch: Throwable -> L13
        if (ShadowHook.init(r102) == 0) goto L11;
        return false;
    L11:
        return applyNative();
    }
}

package com.bytedance.sysoptimizer.runtime;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class DexOptimizer {
    private static final String TAG = "DexOptimizer";

    public DexOptimizer() {
    }

    private static native boolean disable_dex_preload(int r100);

    private static native boolean optimize_dexfile_preload();

    public static boolean optimizeDexFilePreload(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r101 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r102 = new ShadowHook.b();
        r102.f270294a = r101;
        r102.f270295b = true;
        r102.f270296c = false;
        r102.f270297d = false;
        ShadowHook.init(r102);
        optimize_dexfile_preload();     // Catch: Throwable -> L7
    L6:
        return false;
    }

    public static boolean disableDexPreload(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        ByteHook.init();
        disable_dex_preload(r101);     // Catch: Throwable -> L8
        return false;
    L12:
        return false;
    L11:
        return false;
    }
}

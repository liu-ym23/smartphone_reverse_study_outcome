package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class PIMutexOpt {
    public PIMutexOpt() {
    }

    public static native void nStart();

    public static void start(Context r100) {
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
        nStart();
        return;
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class NativeMutexSpinOpt {
    public NativeMutexSpinOpt() {
    }

    private static native void nStart(int r100, int r101, int r102);

    public static void start(Context r100, int r101, int r102) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r103 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r104 = new ShadowHook.b();
        r104.f270294a = r103;
        r104.f270295b = true;
        r104.f270296c = false;
        r104.f270297d = false;
        ShadowHook.init(r104);
        nStart(r101, r102, Build.VERSION.SDK_INT);
        return;
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class PthreadKeyOpt {
    public PthreadKeyOpt() {
    }

    private static native int nStart(int r100, boolean r101, String r102);

    public static int start(Context r100, int r101, boolean r102, String r103) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r104 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r105 = new ShadowHook.b();
        r105.f270294a = r104;
        r105.f270295b = true;
        r105.f270296c = false;
        r105.f270297d = false;
        ShadowHook.init(r105);
        return nStart(r101, r102, r103);
    L6:
        return -1;
    }
}

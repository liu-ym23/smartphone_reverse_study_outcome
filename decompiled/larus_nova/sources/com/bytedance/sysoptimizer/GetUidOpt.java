package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class GetUidOpt {
    public GetUidOpt() {
    }

    private static native void nStart(int r100);

    public static void start(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L12;
        if (r101 >= 0) goto L6;
        return;
    L6:
        if (r101 > 2) goto L14;
        if (r101 != 0) goto L9;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r102 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r103 = new ShadowHook.b();
        r103.f270294a = r102;
        r103.f270295b = true;
        r103.f270296c = false;
        r103.f270297d = false;
        ShadowHook.init(r103);
    L10:
        nStart(r101);
        return;
    L9:
        ByteHook.init();
        goto L10
    L14:
        return;
    }
}

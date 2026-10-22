package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public class SuspendByPeerOptV0 {
    public SuspendByPeerOptV0() {
    }

    private static native int nStart(boolean r100);

    private static void mockTimeout() {
        PthreadThreadV2 r100 = new PthreadThreadV2(new AnonymousClass1(), "SuspendByPeerOptV0");
        ThreadMethodProxy.start(r100);
        ThreadMethodProxy.setName(r100, "hello");
    }

    public static int start(Context r100, boolean r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r102 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r103 = new ShadowHook.b();
        r103.f270294a = r102;
        r103.f270295b = true;
        r103.f270296c = false;
        r103.f270297d = false;
        ShadowHook.init(r103);
        int r104 = nStart(r101);
        if (r101 == false) goto L7;
        mockTimeout();
    L7:
        return r104;
    L8:
        return -1;
    }
}

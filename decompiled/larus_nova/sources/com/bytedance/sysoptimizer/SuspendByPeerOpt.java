package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public class SuspendByPeerOpt {
    public SuspendByPeerOpt() {
    }

    private static native int nStart(boolean r100);

    private static void mockTimeout() {
        PthreadThreadV2 r100 = new PthreadThreadV2(new AnonymousClass1(), "SuspendByPeerOpt");
        ThreadMethodProxy.start(r100);
        ThreadMethodProxy.setName(r100, "hello");
    }

    public static int start(Context r100, boolean r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ByteHook.init();
        int r102 = nStart(r101);
        if (r101 == false) goto L7;
        mockTimeout();
    L7:
        return r102;
    L8:
        return -1;
    }
}

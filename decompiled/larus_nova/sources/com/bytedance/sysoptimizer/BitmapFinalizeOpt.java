package com.bytedance.sysoptimizer;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public class BitmapFinalizeOpt {
    public BitmapFinalizeOpt() {
    }

    private static native int nStart();

    public static int start(Context r100, boolean r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        if (r101 == false) goto L7;
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(), "BitmapFinalizeOpt"));
    L7:
        return nStart();
    L8:
        return -1;
    }
}

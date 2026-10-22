package com.bytedance.salamander.adapter;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements j {
    public final Handler a;

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        return this.a.post(r2);
    }

    public t(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2(r2, r3);
        ThreadMethodProxy.start(r0);
        this.a = new Handler(r0.getLooper());
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        return this.a.postDelayed(r2, r3);
    }
}

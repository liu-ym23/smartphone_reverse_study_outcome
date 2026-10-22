package com.bytedance.salamander.adapter;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f267798a;

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        return this.f267798a.post(r100);
    }

    public t(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100, r101);
        ThreadMethodProxy.start(r102);
        this.f267798a = new Handler(r102.getLooper());
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        return this.f267798a.postDelayed(r100, r101);
    }
}

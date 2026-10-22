package com.bytedance.android.shopping.mall.homepage.opt;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ MallDrainageOpt a;
    public final /* synthetic */ ECHybridListEngine b;

    public d(MallDrainageOpt r1, ECHybridListEngine r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ ECHybridListEngine a;
    public final /* synthetic */ c b;

    public b(ECHybridListEngine r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseFollowStoreListBgPresenter.d0(this.b.a, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

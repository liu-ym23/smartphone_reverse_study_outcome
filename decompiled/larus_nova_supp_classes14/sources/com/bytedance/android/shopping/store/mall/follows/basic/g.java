package com.bytedance.android.shopping.store.mall.follows.basic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ BaseFollowStorePlayControlPresenter.b a;

    public g(BaseFollowStorePlayControlPresenter.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseFollowStorePlayControlPresenter r0 = this.a.a;     // Catch: Throwable -> L4
        int r1 = BaseFollowStorePlayControlPresenter.q;     // Catch: Throwable -> L4
        r0.j0(false, true, true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

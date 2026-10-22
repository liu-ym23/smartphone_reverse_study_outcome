package com.bytedance.android.shopping.store.hybridproduct;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public e0(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.N.getRestoreCoverVisible().setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.shopping.store.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements Runnable {
    public final /* synthetic */ ECShopBackgroundPresenterBrand a;

    public r(ECShopBackgroundPresenterBrand r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopBackgroundPresenterBrand.q0(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

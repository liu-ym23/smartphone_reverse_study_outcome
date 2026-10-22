package com.bytedance.android.shopping.store.search.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Runnable {
    public final /* synthetic */ ShopSearchResultProductListPresenter.c a;

    public q(ShopSearchResultProductListPresenter.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (ShopSearchResultProductListPresenter.e0(this.a.b).isPlayingVideo() == true) goto L9;
        ShopSearchResultProductListPresenter.d0(this.a.b);     // Catch: Throwable -> L6
        return;
    }
}

package com.bytedance.android.shopping.store.hybridproduct;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements Action {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public y(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void run() {
        CompositeDisposable r0 = this.a.J;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.J = null;
    }
}

package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y0 implements View.OnClickListener {
    public final /* synthetic */ ECShopLoadStatusPresenter a;

    public y0(ECShopLoadStatusPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.T().fetchAll(this.a.u().c());
    }
}

package com.bytedance.android.shopping.store.hybridproduct;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public b(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.m0().fetchProductBffApi();
    }
}

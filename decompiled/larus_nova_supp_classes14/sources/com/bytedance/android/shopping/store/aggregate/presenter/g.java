package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ShopAggregatePageProductGroupPresenter a;

    public g(ShopAggregatePageProductGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.d0().refresh();
    }
}

package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ ShopSearchResultTopBarPresenter a;

    public t(ShopSearchResultTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.F().isFormSearchActivity() == false) goto L5;
        ShopSearchResultTopBarPresenter.E(this.a, 11);
        return;
    L5:
        ShopSearchResultTopBarPresenter.D(this.a);
    }
}

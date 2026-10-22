package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public j0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ShopSearchTitlePresenter.G(this.a, ShopSearchBasePresenter.SearchMode.BUTTON);
    }
}

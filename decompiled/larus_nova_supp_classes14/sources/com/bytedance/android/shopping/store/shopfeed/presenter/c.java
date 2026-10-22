package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ECShopFlowShopListPresenter a;

    public c(ECShopFlowShopListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ShopFeedListAdapter r0 = (ShopFeedListAdapter) this.a.g.getValue();
        r0.submitList((PagedList) r2);
    }
}

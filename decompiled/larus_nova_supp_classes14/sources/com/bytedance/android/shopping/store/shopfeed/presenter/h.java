package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ ECShopMomentFlowListPresenter a;

    public h(ECShopMomentFlowListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ShopMomentFlowListAdapter r0 = (ShopMomentFlowListAdapter) this.a.g.getValue();
        r0.submitList((PagedList) r2);
    }
}

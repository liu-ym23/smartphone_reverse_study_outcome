package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedListAdapter;", "Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedListAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedListAdapter extends AbsShopFeedListAdapter {
    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter
    public final void z2() {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter
    public final RecyclerView.ViewHolder A2(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        int r1 = ShopFlowLynxCardViewHolder.b;
        final QLiveData<LoadStatus> r2 = this.d;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r2, "loadStatus");
        ShopFlowLynxCardView r0 = new ShopFlowLynxCardView(r5.getContext(), null, 0);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.setOnLoadLynxSuccessCallback(new ShopFlowLynxCardViewHolder$Companion$create$$inlined$apply$lambda$1(r2));
        return new ShopFlowLynxCardViewHolder(r0);
    }

    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof ShopFlowFooterViewHolder) == true) goto L5;
        r4 = null;
    L5:
        ShopFlowFooterViewHolder r5 = (ShopFlowFooterViewHolder) r4;
        if (r5 == null) goto L9;
        ECShopFeedViewModel r0 = this.g;
        int r2 = ShopFlowFooterViewHolder.c;
        r5.T3(r0, null);
        return;
    }

    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        int r0 = ShopFlowFooterViewHolder.c;
        return ShopFlowFooterViewHolder.a.a(r2);
    }

    public ShopFeedListAdapter(QLiveData<LoadStatus> r2, LifecycleOwner r3, Fragment r4, ECShopFeedViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "loadStatus");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "shopFeedViewModel");
        super(r2, r3, r4, r5);
    }
}

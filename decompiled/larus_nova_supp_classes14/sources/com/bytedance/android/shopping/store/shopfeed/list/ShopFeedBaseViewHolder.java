package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopFeedBaseViewHolder extends RecyclerView.ViewHolder {
    public abstract void T3(a r1, int r2, int r3);

    public abstract void o();

    public ShopFeedBaseViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "holderView");
        super(r2);
    }
}

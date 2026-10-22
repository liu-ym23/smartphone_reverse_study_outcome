package com.bytedance.android.shopping.store.hybridproduct;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopHybridProductLoadMoreViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.android.ec.hybrid.list.ability.k0 {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public final void a() {
        if (this.a.m0().getHasNextPage() != true) goto L27;
        ECHybridListEngine r0 = this.a.n;
        RecyclerView.ViewHolder r2 = null;
        if (r0 == null) goto L15;
        ECHybridRecyclerView r3 = r0.b;
        if (r3 == null) goto L15;
        if (r0 == null) goto L13;
        if (r3 == null) goto L13;
        ECHybridListAdapter r1 = r3.getAdapter();
        if (r1 == null) goto L13;
        int r4 = r1.getItemCount() - 1;
    L14:
        RecyclerView.ViewHolder r5 = r3.findViewHolderForAdapterPosition(r4);
    L17:
        if ((r5 instanceof ECShopHybridProductLoadMoreViewHolder) == false) goto L20;
        r2 = r5;
    L20:
        ECShopHybridProductLoadMoreViewHolder r6 = (ECShopHybridProductLoadMoreViewHolder) r2;
        if (r6 == null) goto L25;
        r6.p.setVisibility(0);
        LoadMoreStatusView r7 = r6.p.findViewById(2131387793);
        r7.setVisibility(0);
        r7.a();
        View r8 = r6.p.findViewById(2131384703);
        if (r8 == null) goto L25;
        r8.setVisibility(8);
    L25:
        this.a.m0().fetchProductBffApi();
        return;
    L13:
        r4 = -1;
    L15:
        r5 = null;
        goto L17
    }

    public j(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }
}

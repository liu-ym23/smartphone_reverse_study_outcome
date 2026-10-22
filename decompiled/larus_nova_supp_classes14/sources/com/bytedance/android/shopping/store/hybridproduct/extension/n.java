package com.bytedance.android.shopping.store.hybridproduct.extension;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public n(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ECHybridListEngine r0 = this.a.n;
        if (r0 == null) goto L14;
        BaseViewHolder r1 = r0.e("__FILTER_SECTION__", "666");
        if (r1 == null) goto L16;
        int r2 = com.bytedance.android.shopping.extensions.k.g(ArraysKt.getOrNull(wg.a.c(((RecyclerView.ViewHolder) r1).itemView), 1), 0) + com.bytedance.android.shopping.extensions.k.g(Integer.valueOf(((RecyclerView.ViewHolder) r1).itemView.getHeight()), 0);
        Integer r3 = (Integer) this.a.N.getMarqueeOffset().getValue();
        if (r3 != null) goto L11;
    L12:
        this.a.N.getMarqueeOffset().setValue(Integer.valueOf(r2));
        return;
    L11:
        if (r3.intValue() != r2) goto L12;
        return;
    L16:
        return;
    }
}

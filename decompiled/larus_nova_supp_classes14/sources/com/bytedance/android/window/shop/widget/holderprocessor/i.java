package com.bytedance.android.window.shop.widget.holderprocessor;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends gr3.d {
    public i() {
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r2, com.bytedance.android.window.shop.repository.tab.entity.f r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "vo");
        if ((r2 instanceof WindowLynxHolder) == false) goto L12;
        WindowLynxHolder r5 = (WindowLynxHolder) r2;
        ViewGroup.LayoutParams r6 = ((RecyclerView.ViewHolder) r5).itemView.getLayoutParams();
        if ((r6 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L7;
        r6 = null;
    L7:
        StaggeredGridLayoutManager.LayoutParams r7 = (StaggeredGridLayoutManager.LayoutParams) r6;
        if (r7 != null) goto L10;
        r7 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
    L10:
        r7.setFullSpan(r5.s4());
        ((RecyclerView.ViewHolder) r5).itemView.setLayoutParams(r7);
        return;
    }
}

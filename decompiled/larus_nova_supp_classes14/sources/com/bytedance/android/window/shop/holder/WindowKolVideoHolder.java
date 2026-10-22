package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.home.tab.presenter.ECWindowProductSharePresenter;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowKolVideoHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/o0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowKolVideoHolder extends ShopWindowGenericHolder<o0> {
    public WindowKolVideoHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560900, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r0 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r0 == null) goto L16;
        int r1 = r0.getSpanIndex();
        if (r7 == 0) goto L9;
        if (r7 == 1) goto L9;
        int r8 = 0;
    L11:
        if ((r1 % 2) != 1) goto L14;
        return new Rect(d.a(Double.valueOf(4.5d)), r8, d.a(12), d.a(9));
    L14:
        return new Rect(d.a(12), r8, d.a(Double.valueOf(4.5d)), d.a(9));
    L9:
        r8 = d.a(8);
        goto L11
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new ECWindowProductSharePresenter(r2);
    }
}

package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.product.presenter.hotsale.ECWindowHotsaleRecommendPCGPresenter;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardLiveHotPlayBackElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleRecommendProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/f;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleRecommendProductHolder extends ShopWindowGenericHolder<f> {
    public WindowHotsaleRecommendProductHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560873, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L10;
        if ((r8.getSpanIndex() % 2) != 1) goto L8;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L8:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ECWindowHotsaleRecommendPCGPresenter r0 = new ECWindowHotsaleRecommendPCGPresenter(r3);
        r0.d0(new ECWindowProductCardLiveHotPlayBackElementPresenter(r3));
        r0.d0(new jq3.a(r3));
        r0.d0(new ECWindowProductCardMainImagePresenter(r3));
        r0.d0(new ECWindowProductCardRecommendInfoElementPresenter(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.b(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.a(r3));
        return r0;
    }
}

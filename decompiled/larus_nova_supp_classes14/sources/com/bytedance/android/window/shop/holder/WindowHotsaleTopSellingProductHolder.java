package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.holder.presenter.WindowReplayStructElementPresenter;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sq3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleTopSellingProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/k;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleTopSellingProductHolder extends ShopWindowGenericHolder<k> {
    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleTopSellingProductHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131561024, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r5) {
        if (getLayoutPosition() != 0) goto L7;
        return new Rect(d.a(12), d.a(4), d.a(12), d.a(8));
    L7:
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        WindowReplayStructElementPresenter r0 = new WindowReplayStructElementPresenter(r5, 308);
        com.bytedance.android.window.shop.product.presenter.group.c r1 = new com.bytedance.android.window.shop.product.presenter.group.c(CollectionsKt.listOf(r0));
        com.bytedance.android.ec.window.base.utils.quick.b r2 = new com.bytedance.android.ec.window.base.utils.quick.b();
        com.bytedance.android.window.shop.product.presenter.group.a r3 = new com.bytedance.android.window.shop.product.presenter.group.a(r5, r1);
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r5));
        r3.d0(new ECWindowProductCardRecommendInfoElementPresenter(r5));
        r3.d0(new ECWindowProductCardTagInfoElementPresenter(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.mainimage.a(r5));
        r2.b(r3, WindowHotsaleTopSellingProductHolder$generatePresenter$1.INSTANCE);
        WindowHotsaleTopSellingProductHolder$generatePresenter$2 r6 = WindowHotsaleTopSellingProductHolder$generatePresenter$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "presenter");
        Intrinsics.checkNotNullParameter(r6, "transformer");
        r2.c(r0, r6);
        return r2;
    }
}

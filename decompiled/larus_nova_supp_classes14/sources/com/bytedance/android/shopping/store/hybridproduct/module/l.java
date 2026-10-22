package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.element.mainimage.ECProductCardMainImagePresenter;
import com.bytedance.android.ec.store.product.presenter.element.price.ECShopProductCardPriceElementPresenterExp;
import com.bytedance.android.ec.store.product.presenter.element.tags.ECShopSeckillInfoAndTagsElementPresenterNew;
import com.bytedance.android.ec.store.product.presenter.element.video.StoreCardVideoElementPresenter;
import com.bytedance.android.shopping.store.hybridproduct.n0;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopProductCardGroupPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends rm.a {
    public final ECStoreViewModel m;
    public final LayoutTypes n;
    public final n0 o;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L8;
        ECShopProductCardGroupPresenter r1 = new ECShopProductCardGroupPresenter(r0, this.m);
        r1.d0(new um.b(r0));
        r1.d0(new ECProductCardMainImagePresenter(r0, this.o.d));
        r1.d0(new StoreCardVideoElementPresenter(r0, this.o.c));
        r1.d0(new vm.a(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.addCart.b(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.mainimage.f(r0));
        if (this.n != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L7;
        r1.d0(new tm.a(r0));
    L7:
        r1.d0(new ECShopProductCardPriceElementPresenterExp(r0, this.n));
        r1.d0(new ECShopSeckillInfoAndTagsElementPresenterNew(r0));
        return r1;
    L8:
        return null;
    }

    public l(View r2, ECStoreViewModel r3, LayoutTypes r4, n0 r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        Intrinsics.checkNotNullParameter(r5, "playableListProxy");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}

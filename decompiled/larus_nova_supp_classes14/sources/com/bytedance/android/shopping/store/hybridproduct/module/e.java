package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.presenter.element.mainimage.ECProductCardMainImagePresenter;
import com.bytedance.android.ec.store.product.presenter.element.price.ECShopProductCardPriceElementPresenterExp;
import com.bytedance.android.ec.store.product.presenter.element.tags.ECShopSeckillInfoAndTagsElementPresenterNew;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopGuessLikeCardGroupPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends rm.a {
    public final ECStoreViewModel m;
    public final boolean n;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        ECShopGuessLikeCardGroupPresenter r1 = new ECShopGuessLikeCardGroupPresenter(r0, this.m, this.n);
        r1.d0(new um.b(r0));
        r1.d0(new ECProductCardMainImagePresenter(r0));
        r1.d0(new vm.a(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.mainimage.f(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.addCart.b(r0));
        r1.d0(new tm.a(r0));
        r1.d0(new ECShopProductCardPriceElementPresenterExp(r0));
        r1.d0(new ECShopSeckillInfoAndTagsElementPresenterNew(r0));
        return r1;
    L5:
        return null;
    }

    public e(View r2, ECStoreViewModel r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.m = r3;
        this.n = r4;
    }
}

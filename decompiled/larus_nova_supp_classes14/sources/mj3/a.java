package mj3;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.element.mainimage.ECProductCardMainImagePresenter;
import com.bytedance.android.ec.store.product.presenter.element.mainimage.f;
import com.bytedance.android.ec.store.product.presenter.element.price.ECShopProductCardPriceElementPresenterExp;
import com.bytedance.android.ec.store.product.presenter.element.tags.ECShopSeckillInfoAndTagsElementPresenter;
import com.bytedance.android.ec.store.product.presenter.element.tags.ECShopSeckillInfoAndTagsElementPresenterNew;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.product.presenter.aggregate.ECAggregateDefaultCardGroupPresenter;
import com.bytedance.android.shopping.store.product.presenter.aggregate.ECFullDiscountProductCardGroupPresenter;
import com.bytedance.android.shopping.store.product.presenter.aggregate.ECShopClassificationProductCardGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;
import um.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends rm.a {
    public final String m;
    public final int n;

    public final QIPresenter h() {
        String r0 = this.m;
        if (Intrinsics.areEqual(r0, AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L9;
        Fragment r1 = a().i();
        if (r1 == null) goto L18;
        ECShopClassificationProductCardGroupPresenter r2 = new ECShopClassificationProductCardGroupPresenter(r1, this.n);
        r2.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r1));
        r2.d0(new ECProductCardMainImagePresenter(r1));
        r2.d0(new f(r1));
        r2.d0(new ECShopProductCardPriceElementPresenterExp(r1));
        r2.d0(new ECShopSeckillInfoAndTagsElementPresenterNew(r1));
        r2.d0(new b(r1));
        return r2;
    L18:
        return null;
    L9:
        if (Intrinsics.areEqual(r0, AggregatePageTypes.FULL_DISCOUNT.getType()) == false) goto L14;
        Fragment r3 = a().i();
        if (r3 == null) goto L19;
        ECFullDiscountProductCardGroupPresenter r4 = new ECFullDiscountProductCardGroupPresenter(r3);
        r4.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r3));
        r4.d0(new ECProductCardMainImagePresenter(r3));
        r4.d0(new com.bytedance.android.ec.store.product.presenter.element.price.a(r3));
        r4.d0(new um.a(r3));
        r4.d0(new ECShopSeckillInfoAndTagsElementPresenter(r3));
        r4.d0(new com.bytedance.android.ec.store.product.presenter.element.addCart.a(r3));
        return r4;
    L19:
        return null;
    L14:
        Fragment r5 = a().i();
        if (r5 == null) goto L20;
        ECAggregateDefaultCardGroupPresenter r6 = new ECAggregateDefaultCardGroupPresenter(r5);
        r6.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r5));
        r6.d0(new ECProductCardMainImagePresenter(r5));
        r6.d0(new com.bytedance.android.ec.store.product.presenter.element.price.a(r5));
        r6.d0(new um.a(r5));
        r6.d0(new ECShopSeckillInfoAndTagsElementPresenter(r5));
        return r6;
    L20:
        return null;
    }

    public a(View r2, String r3, LayoutTypes r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        super(r2);
        this.m = r3;
        this.n = r5;
    }
}

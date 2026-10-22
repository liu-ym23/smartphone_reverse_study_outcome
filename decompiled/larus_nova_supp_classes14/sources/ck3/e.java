package ck3;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.presenter.element.mainimage.ECProductCardMainImagePresenter;
import com.bytedance.android.ec.store.product.presenter.element.price.ECShopProductCardPriceElementPresenterExp;
import com.bytedance.android.ec.store.product.presenter.element.tags.ECShopSeckillInfoAndTagsElementPresenterNew;
import com.bytedance.android.shopping.store.search.presenter.ShopSearchProductCardGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends rm.a {
    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        ShopSearchProductCardGroupPresenter r1 = new ShopSearchProductCardGroupPresenter(r0);
        r1.d0(new ECProductCardMainImagePresenter(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.title.a(r0));
        r1.d0(new com.bytedance.android.ec.store.product.presenter.element.mainimage.f(r0));
        r1.d0(new ECShopProductCardPriceElementPresenterExp(r0));
        r1.d0(new ECShopSeckillInfoAndTagsElementPresenterNew(r0));
        r1.d0(new um.b(r0));
        return r1;
    L5:
        return null;
    }

    public e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}

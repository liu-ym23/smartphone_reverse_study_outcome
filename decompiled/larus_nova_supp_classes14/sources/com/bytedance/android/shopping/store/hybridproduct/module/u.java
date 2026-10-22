package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopSlcProductCardGroupPresenter;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSlicedProductCardPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u extends rm.a {
    public final ECStoreViewModel m;
    public final com.bytedance.android.ecom.arch.slice.render.r n;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        ECShopSlcProductCardGroupPresenter r1 = new ECShopSlcProductCardGroupPresenter(r0, this.m);
        r1.d0(new ShopSlicedProductCardPresenter(r0, this.n, this.m));
        return r1;
    L5:
        return null;
    }

    public u(Fragment r2, ViewGroup r3, ECStoreViewModel r4, com.bytedance.android.ecom.arch.slice.render.r r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3);
        this.m = r4;
        this.n = r5;
    }
}

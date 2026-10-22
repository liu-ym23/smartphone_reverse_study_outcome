package com.bytedance.android.shopping.store.search.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends QFragmentPresenter {
    public n(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r3) {
        ShopSearchFragmentProductViewModel r4 = Y().g(ShopSearchFragmentProductViewModel.class);
        View r5 = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131384670));
        if (r5 == null) goto L6;
        int r0 = ECShopHybridProductListPresenter.O;
        GradientDrawable r1 = ECShopHybridProductListPresenter.a.a(16);
        Intrinsics.checkNotNullParameter(r5, "$this$setBackgroundCompat");
        r5.setBackground(r1);
        return;
    }
}

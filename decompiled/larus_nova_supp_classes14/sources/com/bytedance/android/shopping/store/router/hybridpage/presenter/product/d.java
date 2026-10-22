package com.bytedance.android.shopping.store.router.hybridpage.presenter.product;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSlicedProductCardBasePresenter;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends ShopSlicedProductCardBasePresenter {
    public final HybridPageViewModel x;

    public d(Fragment r2, r r3, LayoutTypes r4, HybridPageViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        super(r2, r3, r4);
        this.x = r5;
    }
}

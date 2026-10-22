package com.bytedance.android.shopping.store.hybridproduct;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.product.ECShopHybridTabFragment;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0 extends QUIModule {
    public final ECStoreViewModel l;
    public final ViewGroup m;
    public final ECShopHybridTabFragment n;

    public final QIPresenter h() {
        return new ECShopHybridProductListPresenter(this.n, this.l);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }

    public h0(ECStoreViewModel r2, ViewGroup r3, ECShopHybridTabFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "storeViewModel");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }
}

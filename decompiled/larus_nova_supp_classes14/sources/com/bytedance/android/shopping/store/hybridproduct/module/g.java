package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopHybridProductLoadMorePresenter;
import com.bytedance.android.shopping.store.router.hybridpage.fragment.HybridPageFragment;
import com.bytedance.android.shopping.store.router.hybridpage.presenter.product.HybridPageListLoadMorePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends QUIModule {
    public final View l;
    public final Fragment m;

    public final QIPresenter h() {
        if ((this.m instanceof HybridPageFragment) == false) goto L6;
        return new HybridPageListLoadMorePresenter(this.m);
    L6:
        return new ECShopHybridProductLoadMorePresenter(this.m);
    }

    public g(View r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        super(-1, null);
        this.l = r3;
        this.m = r4;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}

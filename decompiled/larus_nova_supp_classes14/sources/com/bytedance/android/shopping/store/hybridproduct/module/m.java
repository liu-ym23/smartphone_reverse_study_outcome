package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopRecommendDividerLinePresenter;
import com.bytedance.android.shopping.store.recommend.widget.ShopRecommendDividerView;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends QUIModule {
    public final Fragment l;
    public final ShopRecommendDividerView m;

    public final QIPresenter h() {
        return new ECShopRecommendDividerLinePresenter(this.l, this.m);
    }

    public m(Fragment r3, ShopRecommendDividerView r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "dividerView");
        super(-1, null);
        this.l = r3;
        this.m = r4;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }
}

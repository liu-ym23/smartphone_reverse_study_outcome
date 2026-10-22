package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.status.LazyStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends BaseShopFeedStatusPresenter {
    public i(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.BaseShopFeedStatusPresenter
    public final View D(LazyStatusView r4) {
        Intrinsics.checkNotNullParameter(r4, "root");
        return th.a.c(u().c(), 2131560917, r4, false);
    }
}

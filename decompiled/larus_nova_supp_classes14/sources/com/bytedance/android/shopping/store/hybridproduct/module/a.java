package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopDiscountFilterPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends QUIModule {
    public final ECStoreViewModel l;
    public final View m;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L9;
        ECStoreViewModel r2 = this.l;
        View r3 = this.m;
        if (r3 == null) goto L8;
        return new ECShopDiscountFilterPresenter(r2, r0, (ViewGroup) r3);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        return null;
    }

    public a(ECStoreViewModel r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(2131372717, null);
        this.l = r3;
        this.m = r4;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }
}

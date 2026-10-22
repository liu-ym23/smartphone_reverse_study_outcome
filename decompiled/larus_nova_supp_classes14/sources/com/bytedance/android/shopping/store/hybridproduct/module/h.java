package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.view.ECShopMiddleCouponFilterView;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends QUIModule {
    public final ViewGroup l;
    public final ECShopHybridProductViewModel m;
    public final ECStoreViewModel n;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        Fragment r1 = a().i();
        if (r1 == null) goto L5;
        r0.a(new ECShopMiddleCouponFilterPresenter(r1, this.m, this.n));
    L5:
        return r0;
    }

    public final List<QUIModule> i() {
        return CollectionsKt.emptyList();
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public h(ECShopMiddleCouponFilterView r2, ECShopHybridProductViewModel r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }
}

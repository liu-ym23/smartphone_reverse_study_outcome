package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.ec.store.status.StoreSearchProductLoadingStatusView;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z extends QFragmentPresenter {
    public ShopSearchFragmentProductViewModel f;
    public boolean g;

    public z(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r9) {
        this.f = Y().g(ShopSearchFragmentProductViewModel.class);
        Context r10 = Y().c();
        ViewGroup r0 = (ViewGroup) Z().b(2131387792).f();
        final LazyStatusView r1 = new LazyStatusView(r10, null);
        r0.addView(r1);
        r1.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.a, new com.bytedance.android.ec.store.status.c(new ShopSearchStatusPresenter$initOptStatusView$1(this, r1), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ShopSearchStatusPresenter$initOptStatusView$2(this, r1), null, 6))}));
        r1.a(new StoreSearchProductLoadingStatusView(r10).a());
        ShopSearchFragmentProductViewModel r2 = this.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r2.getLoadStatus().b(ECQuickUtilKt.a(Y()), new y(this, r0, r1, r10));
    }
}

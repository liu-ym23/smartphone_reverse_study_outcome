package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageStatusPresenter extends QFragmentPresenter {
    public final Lazy f;

    public HybridPageStatusPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new HybridPageStatusPresenter$viewModel$2(this, r2));
    }

    public final void b0(QModel r7) {
        Context r8 = Y().c();
        ViewGroup r0 = (ViewGroup) Z().b(2131374649).f();
        final LazyStatusView r1 = new LazyStatusView(r8, null);
        r0.addView(r1);
        r1.setCreators(MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new HybridPageStatusPresenter$initOptStatusView$1(this, r1), null, 6))));
        ((HybridPageViewModel) this.f.getValue()).getLoadStatus().b(Y().e(), new e(r0, r1));
    }
}

package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.status.WindowSearchProductLoadingStatusView;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends QFragmentPresenter {
    public WindowSearchFragmentProductViewModel f;
    public boolean g;

    public t(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r8) {
        this.f = Y().g(WindowSearchFragmentProductViewModel.class);
        Context r9 = Y().c();
        ViewGroup r0 = (ViewGroup) Z().b(2131387792).f();
        final WindowLazyStatusView r1 = new WindowLazyStatusView(r9, null);
        r0.addView(r1);
        r1.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.window.base.status.c.b.a, new com.bytedance.android.ec.window.base.status.d(new WindowSearchStatusPresenter$initOptStatusView$1(this, r1), null, null)), TuplesKt.to(com.bytedance.android.ec.window.base.status.c.c.a, new com.bytedance.android.ec.window.base.status.d(new WindowSearchStatusPresenter$initOptStatusView$2(this, r1), null, null))}));
        Map r2 = new WindowSearchProductLoadingStatusView(r9).a();
        Intrinsics.checkNotNullParameter(r2, "viewCreators");
        r1.removeAllViews();
        ((LinkedHashMap) r1.b).clear();
        r1.a.putAll(r2);
        WindowSearchFragmentProductViewModel r3 = this.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r3.getLoadStatus().b(ECQuickUtilKt.a(Y()), new s(this, r0, r1, r9));
    }
}

package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECTabKitMixRefreshPresenter extends QFragmentPresenter {
    public final Lazy f;
    public SmartRefreshLayout g;

    public ECTabKitMixRefreshPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ECTabKitMixRefreshPresenter$viewModel$2(this, r2));
    }

    public final void b0(QModel r5) {
        this.g = Z().b(2131384142).f();
        int r6 = eh.b.b(((QFragmentPresenter) this).e.getContext()) + com.bytedance.android.shopping.extensions.b.b(44);
        SmartRefreshLayout r0 = this.g;
        if (r0 == null) goto L5;
        wg.a.f(r0, 0, r6, 0, 0);
    L5:
        Context r7 = ((QFragmentPresenter) this).e.getContext();
        if (r7 == null) goto L13;
        com.bytedance.android.shopping.store.tabkit.mixframe.f r1 = new com.bytedance.android.shopping.store.tabkit.mixframe.f(r7);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        SmartRefreshLayout r8 = this.g;
        if (r8 == null) goto L12;
        r8.G(r1, -2);
        r8.g(false);
        r8.A = true;
        r8.W = new f(this);
        return;
    L12:
        return;
    }
}

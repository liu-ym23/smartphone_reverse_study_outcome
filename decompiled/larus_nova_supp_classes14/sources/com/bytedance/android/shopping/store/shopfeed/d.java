package com.bytedance.android.shopping.store.shopfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.shopfeed.presenter.ECShopMomentFlowGuidePresenter;
import com.bytedance.android.shopping.store.shopfeed.presenter.ECShopMomentFlowListPresenter;
import com.bytedance.android.shopping.store.shopfeed.presenter.i;
import com.bytedance.android.shopping.store.shopfeed.presenter.j;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends QUIModule {
    public final View l;
    public final Fragment m;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new j(this.m));
        r0.a(new i(this.m));
        r0.a(new ECShopMomentFlowGuidePresenter(this.m));
        r0.a(new ECShopMomentFlowListPresenter(this.m));
        return r0;
    }

    public d(View r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}

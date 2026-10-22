package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.ECShopFollowBasePresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopAbilityPresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopAnimationPresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopAutoCollapsePresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopCroppedStyleRootPresenterV2;
import com.bytedance.android.shopping.store.home.presenter.ECShopLoadStatusPresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopRootPresenterV2;
import com.bytedance.android.shopping.store.home.presenter.ECShopTabKitCompatPresenter;
import com.bytedance.android.shopping.store.home.presenter.ECShopTopTabPresenter;
import com.bytedance.android.shopping.store.home.presenter.d0;
import com.bytedance.android.shopping.store.home.presenter.i1;
import com.bytedance.android.shopping.store.home.presenter.v;
import com.bytedance.android.shopping.store.home.presenter.w1;
import com.bytedance.android.shopping.store.live.ECShopFloatLivePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends b {
    public final boolean n;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new yi3.b(this.l));
        r0.a(new ECShopFollowBasePresenter(this.l));
        r0.a(new ECShopRootPresenterV2(this.l));
        r0.a(new w1(this.l));
        r0.a(new i1(this.l));
        r0.a(new ECShopLoadStatusPresenter(this.l));
        r0.a(new ECShopAutoCollapsePresenter(this.l));
        r0.a(new ECShopAbilityPresenter(this.l));
        com.bytedance.android.shopping.store.tabkit.f r2 = this.l;
        if (r2 == null) goto L10;
        r0.a(new ECShopTopTabPresenter(r2));
        r0.a(new ECShopTabKitCompatPresenter(this.l));
        r0.a(new ECShopFloatLivePresenter(this.l));
        if (this.n == false) goto L7;
        r0.a(new ECShopCroppedStyleRootPresenterV2(this.l));
    L7:
        r0.a(new v(this.l));
        r0.a(new ECShopAnimationPresenter(this.l));
        return r0;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.ITabKitFragment");
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        r0.add(new b0(this.l));
        r0.add(new a(this.l));
        if (this.n == false) goto L5;
        r0.add(new i(this.l));
    L5:
        r0.add(new c0(this.l));
        r0.add(new j(this.l));
        if (this.n == true) goto L8;
        r0.add(new g(this.l));
        r0.add(new h(this.l));
    L8:
        r0.add(new c(this.l));
        r0.add(new d(this.l));
        r0.add(new o(this.l));
        r0.add(new d0(this.l));
        r0.add(new f(this.l));
        return r0;
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r2) {
        View r3 = this.m;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r3;
    }

    public k(View r2, Fragment r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(-1, r3);
        this.n = r4;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }
}

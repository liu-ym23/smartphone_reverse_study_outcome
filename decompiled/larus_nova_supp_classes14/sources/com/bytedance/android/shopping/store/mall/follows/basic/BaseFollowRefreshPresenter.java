package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowRefreshPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public final Lazy f;
    public SmartRefreshLayout g;
    public final Class<T> h;
    public final boolean i;

    public final void b0(QModel r4) {
        this.g = Z().b(2131384142).f();
        Context r5 = ((QFragmentPresenter) this).e.getContext();
        if (r5 == null) goto L10;
        com.bytedance.android.shopping.store.tabkit.mixframe.f r0 = new com.bytedance.android.shopping.store.tabkit.mixframe.f(r5);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        SmartRefreshLayout r6 = this.g;
        if (r6 == null) goto L9;
        r6.G(r0, -2);
        r6.g(false);
        r6.A = this.i;
        r6.W = new a(this);
        return;
    L9:
        return;
    }

    public final void d0(boolean r11, boolean r12) {
        long r2 = System.currentTimeMillis();
        String r4 = ((BaseFollowStoreViewModel) this.f.getValue()).getSceneId();
        Pair[] r0 = new Pair[1];
        if (r11 == false) goto L5;
        String r13 = "refresh_start";
    L8:
        r0[0] = TuplesKt.to("refresh_status", r13);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.shop.refresh", r2, r4, false, MapsKt.mutableMapOf(r0), false, 32));
        return;
    L5:
        if (r12 == false) goto L7;
        r13 = "refresh_success";
        goto L8
    L7:
        r13 = "refresh_failed";
        goto L8
    }

    public BaseFollowRefreshPresenter(final Fragment r2, Class<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.h = r3;
        this.i = r4;
        this.f = LazyKt.lazy(new BaseFollowRefreshPresenter$viewModel$2(this, r2));
    }
}

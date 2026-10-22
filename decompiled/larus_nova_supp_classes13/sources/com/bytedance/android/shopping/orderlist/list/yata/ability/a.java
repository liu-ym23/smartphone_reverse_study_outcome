package com.bytedance.android.shopping.orderlist.list.yata.ability;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.d;
import v96.e;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.a {
    public final OrderListYataTrackerAbility b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Activity g;
    public final OrderListFragment h;
    public final OrderListViewModel i;

    public final v96.b a() {
        return (v96.b) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).a.getValue();
    }

    public final d b() {
        return (d) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).e.getValue();
    }

    public final f c() {
        return (OrderCommonYataPageCallbackImpl) this.e.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (OrderCommonYataPageCallbackImpl) this.e.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.c e() {
        return (OrderCommonYataPageCallbackImpl) this.e.getValue();
    }

    public final v96.f.a f() {
        return (OrderCommonYataPageCallbackImpl) this.e.getValue();
    }

    public final v96.c getErrorHandler() {
        return (v96.c) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).b.getValue();
    }

    public final g h() {
        return (g) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).d.getValue();
    }

    public final v96.a i() {
        return (OrderListYataApiProtocol) this.f.getValue();
    }

    public final e j() {
        return (e) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).c.getValue();
    }

    public final h g() {
        return this.b;
    }

    public a(FragmentActivity r2, OrderListFragment r3, OrderListViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.b = new OrderListYataTrackerAbility(r4);
        this.c = LazyKt.lazy(new OrderListDefaultAbilityProvider$commonAbilityManager$2(this));
        this.d = LazyKt.lazy(new OrderListDefaultAbilityProvider$viewHolderCallback$2(this));
        this.e = LazyKt.lazy(new OrderListDefaultAbilityProvider$orderCommonPageCallback$2(this));
        this.f = LazyKt.lazy(new OrderListDefaultAbilityProvider$apiProtocol$2(this));
    }
}

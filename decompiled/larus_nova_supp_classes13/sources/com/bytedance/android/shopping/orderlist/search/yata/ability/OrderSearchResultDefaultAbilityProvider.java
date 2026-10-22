package com.bytedance.android.shopping.orderlist.search.yata.ability;

import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.b;
import v96.d;
import v96.e;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultDefaultAbilityProvider extends com.bytedance.kmp.ec.yata.a {
    public final OrderSearchYataTrackerAbility b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final OrderSearchResultActivity g;
    public final OrderSearchResultViewModel h;

    public final b a() {
        return (b) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).a.getValue();
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

    public final c e() {
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
        return (OrderSearchResultYataApiProtocol) this.f.getValue();
    }

    public final e j() {
        return (e) ((com.bytedance.android.shopping.orderlist.common.yata.abilities.b) this.c.getValue()).c.getValue();
    }

    public final h g() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSearchResultDefaultAbilityProvider(OrderSearchResultActivity r2, OrderSearchResultViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.b = new OrderSearchYataTrackerAbility(r3);
        this.c = LazyKt.lazy(new OrderSearchResultDefaultAbilityProvider$commonAbilityManager$2(this));
        this.d = LazyKt.lazy(new OrderSearchResultDefaultAbilityProvider$viewHolderCallback$2(this));
        this.e = LazyKt.lazy(new OrderSearchResultDefaultAbilityProvider$orderCommonPageCallback$2(this));
        this.f = LazyKt.lazy(new OrderSearchResultDefaultAbilityProvider$apiProtocol$2(this));
    }
}

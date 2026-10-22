package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import android.app.Activity;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderCommonAddPreloadTaskFunction;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.a0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.b0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.c0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.d0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.e;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.e0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.f;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.f0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.g0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.h;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.h0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.i;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.i0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.k;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.l;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.m;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.n;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.o;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.p;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.q;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.r;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.s;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.t;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.u;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.v;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.x;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.y;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.z;
import com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c;
import com.bytedance.android.shopping.orderlist.common.freq.func.b;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.d;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonEventCenter {
    public final Lazy a;
    public final Map<String, OrderCommonEventCenter$jsFuncSubscriber$1> b;
    public final List<Pair<String, d>> c;
    public final Activity d;
    public final eg3.a e;
    public final AndroidYaTaInstance f;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a g;

    public static final class a {
    }

    static {
    }

    public final void a() {
        OrderCommonErrorMonitorKt.c(this.g.E0(), "OrderCommonEventCenter-registerAll", new OrderCommonEventCenter$registerAll$1(this));
    }

    public final void b() {
        OrderCommonErrorMonitorKt.c(this.g.E0(), "OrderCommonEventCenter-unregisterAll", new OrderCommonEventCenter$unregisterAll$1(this));
    }

    public OrderCommonEventCenter(Activity r10, eg3.a r11, AndroidYaTaInstance r12, com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "orderCommonPage");
        Intrinsics.checkNotNullParameter(r13, "ability");
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        if (r12 != null) goto L5;
        OrderCommonErrorMonitorKt.b(r13.E0(), "SERIOUS_BUSINESS_ERROR", "OrderCommonEventCenter-init: yataInstance is null");
    L5:
        Lazy r0 = LazyKt.lazy(new OrderCommonEventCenter$bridgeComponent$2(this));
        this.a = r0;
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("operate_success", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "operateSuccess")), TuplesKt.to("operate_fail", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "operateFail")), TuplesKt.to("continue_pay_success", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "continuePaySuccess")), TuplesKt.to("ecom.sku.add.cart", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "ecomSkuAddCart"))});
        this.c = CollectionsKt.listOf(new Pair[]{TuplesKt.to("selfScrollToTop", new q(r13)), TuplesKt.to("selfQueryWhenAppear", new k(r13)), TuplesKt.to("selfQuitPage", new l(r13)), TuplesKt.to("selfQuitSplitContainer", new m(r13)), TuplesKt.to("selfUseBridge", new y(r13, r12, (c) r0.getValue())), TuplesKt.to("selfOrderShowMoreMenu", new i(r13, r10, r12)), TuplesKt.to("selfHeaderShowMenu", new f(r13, r10, r12)), TuplesKt.to("selfScrollToGuessYouLike", new p(r13)), TuplesKt.to("selfToTab", new v(r13)), TuplesKt.to("selfDelay", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.d(r13)), TuplesKt.to("selfSetStatusBar", new u(r10, r13)), TuplesKt.to("selfShowBottomBar", new f0(r13, r11.Md())), TuplesKt.to("selfCloseBottomBar", new b0(r13, r11.Md())), TuplesKt.to("selfSaveNode", new r(r13)), TuplesKt.to("selfDoOnce", new e(r13)), TuplesKt.to("selfRegisterScrollStrategy", new n(r13)), TuplesKt.to("selfUpdateRawParams", new x(r13)), TuplesKt.to("selfResetGuessYouLike", new o(r13)), TuplesKt.to("selfUpdateCustomFields", new i0()), TuplesKt.to("selfRegisterBridgeEvent", new c0(r13, r12)), TuplesKt.to("selfUnregisterBridgeEvent", new h0(r13)), TuplesKt.to("selfScrollMainList", new e0(r13)), TuplesKt.to("selfScrollToPosition", new z(r13)), TuplesKt.to("selfJudgeFrequency", new b(r13)), TuplesKt.to("selfControlFrequency", new com.bytedance.android.shopping.orderlist.common.freq.func.a(r13)), TuplesKt.to("selfTabBubble", new g0(r13)), TuplesKt.to("selfTransformLocation", new w(r13, r12)), TuplesKt.to("selfOpenMaskLayer", new h(r13)), TuplesKt.to("selfCloseMaskLayer", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.c(r13)), TuplesKt.to("selfSaveTrigger", new s(r13)), TuplesKt.to("selfAddPreloadTask", new OrderCommonAddPreloadTaskFunction(r13)), TuplesKt.to("selfAddExParams", new a0(r13)), TuplesKt.to("selfRemoveExParams", new d0(r13)), TuplesKt.to("selfBeforeChangeTab", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.b(r13)), TuplesKt.to("selfUIAction", new t(r13, r12))});
    }
}

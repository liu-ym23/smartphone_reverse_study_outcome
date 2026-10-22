package com.bytedance.android.shopping.orderlist.common.yata.abilities;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.biz.callback.k;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v96.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonYataPageCallbackImpl implements f.a, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.d {
    public final CopyOnWriteArrayList<Function0<Unit>> a;
    public final com.bytedance.android.shopping.orderlist.common.controller.f b;
    public final a c;

    public final void a() {
        this.c.a();
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
    }

    public final void c(YataStoreData r2) {
        Intrinsics.checkNotNullParameter(r2, "storeData");
        final aa6.a r3 = r2.c;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onProtocolDispatchEnd$1(r3));
    }

    public final void e(final com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        final aa6.a.b.b r0 = aa6.a.b.b.b;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter(r4, "model");
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onFetchBegin$1(r0));
        m.a r2 = m.a;
        m.c(new OrderCommonYataPageCallbackImpl$onFetchBegin$2(this, r0, r4));
    }

    @Deprecated(message = "老版的临时过渡的接口方法，SDK不再深度维护，最好不要使用")
    public final void l(com.bytedance.kmp.ec.yata.store.node.c r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r2, "node");
    }

    public OrderCommonYataPageCallbackImpl(com.bytedance.android.shopping.orderlist.common.controller.f r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "pageCallback");
        Intrinsics.checkNotNullParameter(r3, "viewHolderCallback");
        this.b = r2;
        this.c = r3;
        this.a = new CopyOnWriteArrayList();
    }

    public final void f(YataStoreData r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "storeData");
        final aa6.a r4 = r2.c;
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onProtocolReloadEnd$1(r4));
        m.a r6 = m.a;
        m.c(new OrderCommonYataPageCallbackImpl$onProtocolReloadEnd$2(this, r4));
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r2, r3);
    }

    public final void h(i r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
    }

    public final void d(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.a(r2, r3, r4);
    }

    public final void i(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.c(r2, r3, r4);
    }

    public final void k(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.d(r2, r3, r4);
    }

    public final void m(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.b(r2, r3, r4);
    }

    public final void j(final aa6.a r1, final Object r2, final com.bytedance.kmp.ec.yata.common.biz.callback.a r3, k r4, h r5, com.bytedance.kmp.ec.yata.event.ability.uplink.b r6) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r5, "responseInfo");
        Lazy r7 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onFetchEnd$1(r1));
        m.a r8 = m.a;
        m.c(new OrderCommonYataPageCallbackImpl$onFetchEnd$2(this, r1, r2, r3));
    }
}

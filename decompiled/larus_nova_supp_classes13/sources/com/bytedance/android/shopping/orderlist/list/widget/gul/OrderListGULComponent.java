package com.bytedance.android.shopping.orderlist.list.widget.gul;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListGULComponent implements jg3.a {
    public l a;
    public Function0<Unit> b;
    public final Lazy c;
    public final Context d;
    public final OrderListFragment e;
    public final ViewGroup f;

    @Override // jg3.a
    public final void release() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListGULComponent", AnonymousClass1.INSTANCE);
        l r1 = this.a;
        if (r1 == null) goto L6;
        r1.release();
        return;
    }

    @Override // jg3.a
    public final void a(Function0<Unit> r19) {
        ig3.a r1 = this.e.K;
        l r2 = null;
        if (r1 == null) goto L5;
        OrderCommonBusinessMonitor r3 = r1.c;
    L6:
        if (r3 == null) goto L8;
        r3.c = System.currentTimeMillis();
        r3.c("load_gul_start", null);
    L8:
        this.b = r19;
        if (this.a != null) goto L14;
        final long r4 = System.currentTimeMillis();
        ViewGroup r9 = this.f;
        Context r6 = this.d;
        ECLiveHybridUtil.HybridType r11 = ECLiveHybridUtil.HybridType.LYNX;
        String r7 = (String) this.c.getValue();
        JSONObject r5 = new JSONObject();
        r5.put("module_param", new JSONObject());
        r5.put("mob_data", new JSONObject());
        Unit r8 = Unit.INSTANCE;
        l r10 = ECLiveHybridUtil.b(r6, r7, com.bytedance.android.shopping.hybrid.a.b(r5), r9, new c(this), r11, null, false, null, null, false, 4032);
        if (r10 == null) goto L13;
        r10.registerMethod("x.publishEvent", new b(this));
        r2 = r10;
    L13:
        this.a = r2;
        final long r12 = System.currentTimeMillis();
        Lazy r13 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListGULComponent", new OrderListGULComponent$initOrReload$1(r12, r4));
        return;
    L14:
        final long r14 = System.currentTimeMillis();
        l r15 = this.a;
        if (r15 == null) goto L17;
        r15.loadUrl((String) this.c.getValue());
    L17:
        final long r16 = System.currentTimeMillis();
        Lazy r17 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListGULComponent", new OrderListGULComponent$initOrReload$2(r16, r14));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public OrderListGULComponent(Context r2, OrderListFragment r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "container");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.c = LazyKt.lazy(new OrderListGULComponent$gulUrl$2(this));
    }
}

package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonScrollStrategyController {
    public final ConcurrentHashMap<String, w> a;
    public boolean b;
    public final AndroidYaTaInstance c;

    public OrderCommonScrollStrategyController(AndroidYaTaInstance r1) {
        this.c = r1;
        this.a = new ConcurrentHashMap();
    }

    public final void b(final long r14) {
        if (this.b == false) goto L30;
        Iterator<Map.Entry<String, w>> r0 = this.a.entrySet().iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L23;
        final w r3 = r0.next().getValue();
        AndroidYaTaInstance r4 = this.c;
        if (r3.a > 0) goto L10;
    L14:
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonScrollStrategyController", ScrollStrategy$handleStrategy$2.INSTANCE);
        if (r14 >= r3.c) goto L18;
        OrderCommonLog.a("OrderCommonScrollStrategyController", ScrollStrategy$handleStrategy$3.INSTANCE);
        r3.b = true;
    L18:
        if (r3.a <= 0) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L6;
        r2 = true;
        goto L6
    L20:
        r6 = false;
        goto L21
    L10:
        if (r14 < r3.c) goto L14;
        if (r3.b == false) goto L14;
        r3.b = false;
        Lazy r7 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonScrollStrategyController", new ScrollStrategy$handleStrategy$1(r3, r14));
        r3.a--;
        com.bytedance.android.shopping.orderlist.common.utils.q.b(r4, new com.bytedance.android.shopping.orderlist.common.utils.f(r3.d, r3.e, null), null, "handleScrollStrategy");
        goto L18
    L23:
        this.b = r2;
        return;
    }

    public final void a(final String r3, w r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "strategy");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonScrollStrategyController", new OrderCommonScrollStrategyController$addStrategy$1(r3));
        this.b = true;
        if (this.a.contains(r3) == false) goto L5;
        return;
    L5:
        this.a.put(r3, r4);
    }
}

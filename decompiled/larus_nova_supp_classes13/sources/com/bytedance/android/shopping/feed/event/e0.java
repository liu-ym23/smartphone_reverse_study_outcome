package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;

    public e0(Integer r1, Context r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        i1 r0 = new i1("click_mall_entrance");
        r0.a = "product_flow_float";
        r0.b = this.d;
        Integer r1 = this.a;
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L13:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L11:
        if (r1.intValue() != 0) goto L13;
        g.b(r0, this.b);
        goto L13
    L6:
        if (r1.intValue() != 2) goto L8;
        g.a(r0, this.b, this.c);
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

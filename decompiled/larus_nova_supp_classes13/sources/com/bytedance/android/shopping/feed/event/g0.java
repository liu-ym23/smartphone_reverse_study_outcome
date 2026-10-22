package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;

    public g0(Integer r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        this.a = r1;
        this.b = null;
        this.c = null;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = "0";
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        x0 r0 = new x0();
        String r1 = this.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.a = r1;
        String r3 = this.e;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.b = r3;
        String r4 = this.f;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0.c = r4;
        String r5 = this.g;
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r0.d = r5;
        String r6 = this.h;
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.e = r6;
        String r7 = this.i;
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r0.f = r7;
        String r8 = this.j;
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r0.g = r8;
        String r9 = this.k;
        if (r9 == null) goto L27;
        r2 = r9;
    L27:
        r0.h = r2;
        Integer r10 = this.a;
        if (r10 != null) goto L31;
    L33:
        if (r10 != null) goto L36;
    L38:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L36:
        if (r10.intValue() != 0) goto L38;
        g.b(r0, this.b);
        goto L38
    L31:
        if (r10.intValue() != 2) goto L33;
        g.a(r0, this.b, this.c);
        goto L38
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

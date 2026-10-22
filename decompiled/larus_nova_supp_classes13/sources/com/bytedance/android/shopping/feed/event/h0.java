package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ rd3.a d;

    public h0(Integer r1, Context r2, List r3, rd3.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        z0 r0 = new z0("ecom_inflow_trending_show");
        rd3.a r1 = this.d;
        if (r1 == null) goto L5;
        String r2 = r1.h;
    L6:
        r0.a = r2;
        JsonObject r3 = new JsonObject();
        rd3.a r4 = this.d;
        if (r4 == null) goto L24;
        yd3.p r5 = r4.i();
        if (r5 == null) goto L24;
        yd3.q r6 = r5.o();
        if (r6 == null) goto L24;
        ArrayList<SearchItem> r7 = r6.c();
        if (r7 == null) goto L24;
        Iterator<T> r8 = r7.iterator();
        int r9 = 0;
    L16:
        if (r8.hasNext() == false) goto L24;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        String r12 = ((SearchItem) r10).getKeyword();
        if (r12 == null) goto L23;
        r3.addProperty(String.valueOf(r9), r12);
    L23:
        r9 = r11;
    L24:
        r0.b = r3.toString();
        Integer r13 = this.a;
        if (r13 != null) goto L28;
    L30:
        if (r13 != null) goto L33;
    L35:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L33:
        if (r13.intValue() != 0) goto L35;
        g.b(r0, this.b);
        goto L35
    L28:
        if (r13.intValue() != 2) goto L30;
        g.a(r0, this.b, this.c);
        goto L35
    L5:
        r2 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

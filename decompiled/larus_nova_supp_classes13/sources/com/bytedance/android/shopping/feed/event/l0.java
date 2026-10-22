package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ PromotionProductStruct d;
    public final /* synthetic */ rd3.a e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Map h;

    public l0(Integer r1, Context r2, PromotionProductStruct r3, rd3.a r4, String r5, boolean r6, Map r7) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        PromotionProductStruct r1 = this.d;
        rd3.a r2 = this.e;
        String r3 = this.f;
        boolean r4 = this.g;
        Map r5 = this.h;
        r0.getClass();
        d2 r6 = FeedProductEventTracker.e(r1, r2, r3, r4, r5);
        Integer r7 = this.a;
        if (r7 != null) goto L6;
    L8:
        if (r7 != null) goto L11;
    L13:
        r6.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r6.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r6;
    L11:
        if (r7.intValue() != 0) goto L13;
        g.b(r6, this.b);
        goto L13
    L6:
        if (r7.intValue() != 2) goto L8;
        g.a(r6, this.b, this.c);
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

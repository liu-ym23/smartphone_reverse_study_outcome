package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ AnchorV3Param d;
    public final /* synthetic */ rd3.a e;
    public final /* synthetic */ PromotionProductStruct f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ Map i;

    public f0(Integer r1, Context r2, AnchorV3Param r3, rd3.a r4, PromotionProductStruct r5, String r6, boolean r7, Map r8) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        AnchorV3Param r1 = this.d;
        rd3.a r2 = this.e;
        PromotionProductStruct r3 = this.f;
        String r4 = this.g;
        boolean r5 = this.h;
        Map r6 = this.i;
        r0.getClass();
        jd3.u r7 = FeedProductEventTracker.d(r1, r2, r3, r4, r5, r6);
        Integer r8 = this.a;
        if (r8 != null) goto L6;
    L8:
        if (r8 != null) goto L11;
    L13:
        r7.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r7.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r7;
    L11:
        if (r8.intValue() != 0) goto L13;
        g.b(r7, this.b);
        goto L13
    L6:
        if (r8.intValue() != 2) goto L8;
        g.a(r7, this.b, this.c);
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

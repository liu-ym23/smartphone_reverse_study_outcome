package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ AnchorV3Param e;

    public o0(Integer r1, Context r2, AnchorV3Param r3) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = 0;
        this.e = r3;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        a2 r0 = new a2();
        r0.a = String.valueOf(this.d);
        AnchorV3Param r1 = this.e;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getVideoId();
    L6:
        r0.b = r3;
        AnchorV3Param r4 = this.e;
        if (r4 == null) goto L9;
        String r5 = r4.getAuthorId();
    L10:
        r0.c = r5;
        AnchorV3Param r6 = this.e;
        if (r6 == null) goto L15;
        ECLogExtraData r7 = r6.getLogExtraData();
        if (r7 == null) goto L15;
        r2 = r7.getEnterFrom();
    L15:
        r0.d = r2;
        Integer r8 = this.a;
        if (r8 != null) goto L19;
    L21:
        if (r8 != null) goto L24;
    L26:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L24:
        if (r8.intValue() != 0) goto L26;
        g.b(r0, this.b);
        goto L26
    L19:
        if (r8.intValue() != 2) goto L21;
        g.a(r0, this.b, this.c);
        goto L26
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}

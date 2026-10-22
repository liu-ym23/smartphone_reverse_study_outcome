package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends f {
    public final int j;
    public final f k;
    public final f l;

    public n(f r6, f r7) {
        Intrinsics.checkNotNullParameter(r6, "first");
        Intrinsics.checkNotNullParameter(r7, "second");
        ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> r0 = com.bytedance.android.window.shop.holder.factory.c.a;
        int r1 = r6.i;
        int r2 = r7.i;
        ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> r3 = com.bytedance.android.window.shop.holder.factory.c.a;
        ConcurrentHashMap<Integer, Integer> r4 = r3.get(Integer.valueOf(r1));
        if (r4 != null) goto L5;
        r4 = new ConcurrentHashMap();
        r3.put(Integer.valueOf(r1), r4);
    L5:
        Integer r5 = r4.get(Integer.valueOf(r2));
        if (r5 != null) goto L8;
        r5 = Integer.valueOf(com.bytedance.android.window.shop.holder.factory.c.e.getAndIncrement());
        r4.put(Integer.valueOf(r2), r5);
        com.bytedance.android.window.shop.holder.factory.c.b.put(r5, TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r2)));
    L8:
        super(r5.intValue());
        this.k = r6;
        this.l = r7;
        int r8 = 1;
        if ((r6 instanceof n) == false) goto L11;
        int r9 = ((n) r6).j;
    L13:
        if ((r7 instanceof n) == false) goto L15;
        r8 = ((n) r7).j;
    L15:
        this.j = r9 + r8;
        return;
    L11:
        r9 = 1;
        goto L13
    }
}

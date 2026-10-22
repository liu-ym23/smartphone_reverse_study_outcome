package com.bytedance.android.shopping.ligo.monitor;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;

    public d(String r1) {
        this.a = r1;
    }

    public static Map a(ll.a r4, Pair... r5) {
        int r2 = 0;
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", r4.e()), TuplesKt.to("region_name", r4.b()), TuplesKt.to("region_type", String.valueOf(r4.d())), TuplesKt.to("dynamic_type", String.valueOf(r4.a()))});
        int r0 = r5.length;
    L3:
        if (r2 >= r0) goto L6;
        Pair r1 = r5[r2];
        r6.put(r1.getFirst(), r1.getSecond());
        r2 = r2 + 1;
        goto L3
    L6:
        return MapsKt.toMap(r6);
    }
}

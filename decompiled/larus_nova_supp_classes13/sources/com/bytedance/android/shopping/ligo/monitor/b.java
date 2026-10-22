package com.bytedance.android.shopping.ligo.monitor;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static Map a(ll.a r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getTrackMap");
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", r3.e()), TuplesKt.to("region_name", r3.b()), TuplesKt.to("region_type", String.valueOf(r3.d())), TuplesKt.to("dynamic_type", String.valueOf(r3.a()))});
    }
}

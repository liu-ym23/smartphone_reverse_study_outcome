package com.bytedance.revenue.platform.api.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = 0;
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        LinkedHashMap r103 = new LinkedHashMap();
        int r104 = r100.length;
    L10:
        if (r101 >= r104) goto L12;
        Pair<? extends K, ? extends V> r105 = r100[r101];
        r103.put(r105.getFirst(), r105.getSecond());
        r101 = r101 + 1;
        goto L10
    L12:
        return r103;
    L8:
        return new LinkedHashMap();
    L5:
        r102 = false;
        goto L6
    }
}

package com.larus.video.impl.sdk.prefetch;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b0 {
    public static final <T> List<T> a(List<? extends T> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = RangesKt.coerceAtLeast(r101, 0);     // Catch: Exception -> L8
        int r104 = RangesKt.coerceAtMost(r102, r100.size());     // Catch: Exception -> L8
        if (r103 < r104) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return r100.subList(r103, r104);
    L9:
        return CollectionsKt.emptyList();
    }
}

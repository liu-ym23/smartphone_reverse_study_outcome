package com.larus.bmhome.chat.trace.appreciable;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x<T> implements Comparator {
    public x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Object r102 = ((Pair) r100).getSecond();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Long");
        Object r103 = ((Pair) r101).getSecond();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Long");
        return ComparisonsKt.compareValues((Long) r102, (Long) r103);
    }
}

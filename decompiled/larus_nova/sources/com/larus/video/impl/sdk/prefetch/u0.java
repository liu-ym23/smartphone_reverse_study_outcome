package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class u0<T> implements Comparator {
    public u0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((c) ((Map.Entry) r101).getValue()).f375849a), Long.valueOf(((c) ((Map.Entry) r100).getValue()).f375849a));
    }
}

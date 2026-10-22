package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class s0<T> implements Comparator {
    public s0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((g) ((Map.Entry) r101).getValue()).f375861d), Long.valueOf(((g) ((Map.Entry) r100).getValue()).f375861d));
    }
}

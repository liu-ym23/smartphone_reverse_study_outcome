package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class h1<T> implements Comparator {
    public h1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((i) ((Map.Entry) r101).getValue()).f375869a), Long.valueOf(((i) ((Map.Entry) r100).getValue()).f375869a));
    }
}

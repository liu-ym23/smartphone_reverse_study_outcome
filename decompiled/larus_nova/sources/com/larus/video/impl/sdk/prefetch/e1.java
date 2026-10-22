package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e1<T> implements Comparator {
    public e1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((a) ((Map.Entry) r101).getValue()).f375845a), Long.valueOf(((a) ((Map.Entry) r100).getValue()).f375845a));
    }
}

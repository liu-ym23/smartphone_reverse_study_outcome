package com.bytedance.upc;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o<T> implements Comparator<T> {
    public o() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IUpcLifecycleService) r100).priority()), Integer.valueOf(((IUpcLifecycleService) r101).priority()));
    }
}

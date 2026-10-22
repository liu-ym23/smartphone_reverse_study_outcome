package com.larus.dora.impl.resource;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e0<T> implements Comparator {
    public e0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((o) r100).f337902a.f337893a, ((o) r101).f337902a.f337893a);
    }
}

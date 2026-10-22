package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class u<T> implements Comparator {
    public u() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((o0) r101).f330781b, ((o0) r100).f330781b);
    }
}

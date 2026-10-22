package com.obric.audio.enroll;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((String) ((Pair) r100).getFirst(), (String) ((Pair) r101).getFirst());
    }
}

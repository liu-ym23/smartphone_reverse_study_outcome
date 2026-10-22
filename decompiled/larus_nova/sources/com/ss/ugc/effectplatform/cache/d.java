package com.ss.ugc.effectplatform.cache;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((k) r100).f457352h), Long.valueOf(((k) r101).f457352h));
    }
}

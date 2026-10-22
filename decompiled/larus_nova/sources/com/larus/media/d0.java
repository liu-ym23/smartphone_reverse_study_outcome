package com.larus.media;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d0<T> implements Comparator {
    public d0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.larus.media.model.a) r101).f359119g), Integer.valueOf(((com.larus.media.model.a) r100).f359119g));
    }
}

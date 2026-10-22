package com.obric.audio.enroll.sidauth;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((g.a) r100).f395558f), Long.valueOf(((g.a) r101).f395558f));
    }
}

package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g0<T> implements Comparator {
    public g0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((f0.a) r100).f298735a.getFirst()), Integer.valueOf(((f0.a) r101).f298735a.getFirst()));
    }
}

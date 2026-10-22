package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class h0<T> implements Comparator {
    public h0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r101).getFirst(), (Integer) ((Triple) r100).getFirst());
    }
}

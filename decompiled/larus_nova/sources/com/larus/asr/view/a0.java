package com.larus.asr.view;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a0<T> implements Comparator {
    public a0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((y48.i) r101).f566104c), Integer.valueOf(((y48.i) r100).f566104c));
    }
}

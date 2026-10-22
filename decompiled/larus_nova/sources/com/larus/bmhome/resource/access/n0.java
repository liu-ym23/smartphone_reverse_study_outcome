package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class n0<T> implements Comparator {
    public n0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((l0) r100).d().getOrder()), Integer.valueOf(((l0) r101).d().getOrder()));
    }
}

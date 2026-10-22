package com.ss.android.lark.flow.common.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((a) r100).getType().getOrder()), Integer.valueOf(((a) r101).getType().getOrder()));
    }
}

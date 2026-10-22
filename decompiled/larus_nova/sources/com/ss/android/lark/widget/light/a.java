package com.ss.android.lark.widget.light;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r100).getFirst(), (Integer) ((Pair) r101).getFirst());
    }
}

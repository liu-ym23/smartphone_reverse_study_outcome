package com.bytedance.badger.z;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class o0 implements Comparator {
    public o0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ComparisonsKt.compareValues((String) ((Pair) r100).component1(), (String) ((Pair) r101).component1());
    }
}

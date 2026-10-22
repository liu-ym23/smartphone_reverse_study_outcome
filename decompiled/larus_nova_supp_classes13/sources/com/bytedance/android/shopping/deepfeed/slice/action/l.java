package com.bytedance.android.shopping.deepfeed.slice.action;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l<T> implements Comparator<T> {
    public l() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r1).getFirst(), (Integer) ((Triple) r2).getFirst());
    }
}

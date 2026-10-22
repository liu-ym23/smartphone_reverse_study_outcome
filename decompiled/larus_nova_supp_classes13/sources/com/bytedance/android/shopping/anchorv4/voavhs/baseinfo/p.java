package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p<T> implements Comparator<T> {
    public p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((w.b) r1).a), Integer.valueOf(((w.b) r2).a));
    }
}

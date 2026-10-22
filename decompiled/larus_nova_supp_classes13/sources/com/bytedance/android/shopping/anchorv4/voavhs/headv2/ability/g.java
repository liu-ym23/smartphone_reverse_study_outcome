package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Comparator<T> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q) r1).j), Integer.valueOf(((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q) r2).j));
    }
}

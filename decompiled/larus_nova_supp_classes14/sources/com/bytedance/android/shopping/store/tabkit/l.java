package com.bytedance.android.shopping.store.tabkit;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l<T> implements Comparator<T> {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(((com.bytedance.android.shopping.store.tabkit.model.i) r1).c(), ((com.bytedance.android.shopping.store.tabkit.model.i) r2).c());
    }
}

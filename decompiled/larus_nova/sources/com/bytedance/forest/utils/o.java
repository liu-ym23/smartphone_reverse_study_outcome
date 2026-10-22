package com.bytedance.forest.utils;

import com.bytedance.forest.model.HttpResponseCache;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class o<T> implements Comparator<T> {
    public o() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((HttpResponseCache) r100).f244255e), Integer.valueOf(((HttpResponseCache) r101).f244255e));
    }
}

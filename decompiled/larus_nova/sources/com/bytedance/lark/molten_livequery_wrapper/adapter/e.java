package com.bytedance.lark.molten_livequery_wrapper.adapter;

import com.bytedance.lark.molten_livequery.g;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((g) r101).f253343a), Long.valueOf(((g) r100).f253343a));
    }
}

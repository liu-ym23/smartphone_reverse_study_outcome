package com.larus.reach.runtime;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class o<T> implements Comparator {
    public o() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((ReachBannerRuntime.c) r100).f367267c), Long.valueOf(((ReachBannerRuntime.c) r101).f367267c));
    }
}

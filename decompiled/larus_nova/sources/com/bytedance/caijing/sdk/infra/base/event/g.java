package com.bytedance.caijing.sdk.infra.base.event;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Comparator {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((DynamicEventTracker.a) r100).f202331c), Long.valueOf(((DynamicEventTracker.a) r101).f202331c));
    }
}

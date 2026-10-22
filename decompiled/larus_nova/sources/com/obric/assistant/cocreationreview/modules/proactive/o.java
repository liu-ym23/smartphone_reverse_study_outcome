package com.obric.assistant.cocreationreview.modules.proactive;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class o<T> implements Comparator {
    public o() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((q) r101).f387496f), Long.valueOf(((q) r100).f387496f));
    }
}

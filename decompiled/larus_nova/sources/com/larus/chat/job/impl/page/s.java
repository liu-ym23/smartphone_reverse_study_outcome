package com.larus.chat.job.impl.page;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class s<T> implements Comparator {
    public s() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Map.Entry) r100).getKey(), (Integer) ((Map.Entry) r101).getKey());
    }
}

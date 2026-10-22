package com.suite.lark.component.logger.dynamic;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Map.Entry) r101).getValue(), (Integer) ((Map.Entry) r100).getValue());
    }
}

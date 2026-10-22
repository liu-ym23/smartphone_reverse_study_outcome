package io1;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Long) ((Map.Entry) r101).getValue(), (Long) ((Map.Entry) r100).getValue());
    }
}

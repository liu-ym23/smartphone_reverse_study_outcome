package io.noties.markwon.ext.onetex;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class w<T> implements Comparator<T> {
    public w() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Map.Entry) r100).getKey(), (Integer) ((Map.Entry) r101).getKey());
    }
}

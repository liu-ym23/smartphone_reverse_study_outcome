package com.larus.business.markdown.impl.widget;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((pw8.b) r100).priority()), Integer.valueOf(((pw8.b) r101).priority()));
    }
}

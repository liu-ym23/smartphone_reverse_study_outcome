package com.larksuite.component.ui.tag;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((TagsDrawable.d) r100).f284413b), Integer.valueOf(((TagsDrawable.d) r101).f284413b));
    }
}

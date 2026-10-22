package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class v1<T> implements Comparator {
    public v1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ObricMentionHighlightHelper.b) r100).f393615a), Integer.valueOf(((ObricMentionHighlightHelper.b) r101).f393615a));
    }
}

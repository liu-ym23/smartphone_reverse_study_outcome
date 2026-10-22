package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class u1<T> implements Comparator {
    public u1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ObricMentionHighlightHelper.b r102 = (ObricMentionHighlightHelper.b) r101;
        ObricMentionHighlightHelper.b r103 = (ObricMentionHighlightHelper.b) r100;
        return ComparisonsKt.compareValues(Integer.valueOf(r102.f393616b - r102.f393615a), Integer.valueOf(r103.f393616b - r103.f393615a));
    }
}

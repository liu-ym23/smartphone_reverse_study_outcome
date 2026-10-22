package com.bytedance.ee.bear.middleground.comment.input;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class u<T> implements Comparator {
    public u() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r101).f232008a.length()), Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r100).f232008a.length()));
    }
}

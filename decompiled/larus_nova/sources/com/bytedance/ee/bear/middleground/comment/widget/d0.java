package com.bytedance.ee.bear.middleground.comment.widget;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d0<T> implements Comparator {
    public d0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((v.h) r101).f232372c.getFirst()), Integer.valueOf(((v.h) r100).f232372c.getFirst()));
    }
}

package com.bytedance.ee.bear.middleground.comment.widget;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0<T> implements Comparator {
    public d0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((v.h) r2).c.getFirst()), Integer.valueOf(((v.h) r1).c.getFirst()));
    }
}

package com.bytedance.ee.bear.middleground.comment.input;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w0<T> implements Comparator {
    public w0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r2).a.length()), Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r1).a.length()));
    }
}

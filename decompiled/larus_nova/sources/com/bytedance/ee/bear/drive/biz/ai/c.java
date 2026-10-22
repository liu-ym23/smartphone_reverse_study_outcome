package com.bytedance.ee.bear.drive.biz.ai;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((e) r100).f222593a), Integer.valueOf(((e) r101).f222593a));
    }
}

package com.larus.feishu.office.im.impl.officemention;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class q<T> implements Comparator {
    public q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((r) r100).f343259a), Integer.valueOf(((r) r101).f343259a));
    }
}

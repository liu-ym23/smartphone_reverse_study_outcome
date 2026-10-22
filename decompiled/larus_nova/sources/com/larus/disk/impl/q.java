package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class q<T> implements Comparator {
    public q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        boolean r102 = true;
        if (((com.larus.disk.api.h) r100).f330536d != null) goto L5;
        boolean r103 = true;
    L6:
        Boolean r104 = Boolean.valueOf(r103);
        if (((com.larus.disk.api.h) r101).f330536d == null) goto L11;
        r102 = false;
    L11:
        return ComparisonsKt.compareValues(r104, Boolean.valueOf(r102));
    L5:
        r103 = false;
        goto L6
    }
}

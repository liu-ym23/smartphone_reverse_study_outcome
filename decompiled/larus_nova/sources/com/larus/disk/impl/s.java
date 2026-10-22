package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class s<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f330810a;

    public s(q r100) {
        this.f330810a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f330810a.compare(r100, r101);
        if (r102 != 0) goto L15;
        long r103 = ((com.larus.disk.api.h) r101).f330536d;
        if (r103 != null) goto L9;
        r103 = -1L;
    L9:
        long r104 = ((com.larus.disk.api.h) r100).f330536d;
        if (r104 != null) goto L14;
        r104 = -1L;
    L14:
        return ComparisonsKt.compareValues(r103, r104);
    L15:
        return r102;
    }
}

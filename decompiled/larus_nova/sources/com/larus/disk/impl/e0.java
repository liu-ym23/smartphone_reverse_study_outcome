package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f330629a;

    public e0(c0 r100) {
        this.f330629a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f330629a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(Long.valueOf(((p0) r101).f330787d), Long.valueOf(((p0) r100).f330787d));
    }
}

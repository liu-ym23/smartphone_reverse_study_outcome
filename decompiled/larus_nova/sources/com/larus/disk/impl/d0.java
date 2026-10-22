package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class d0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f330627a;

    public d0(e0 r100) {
        this.f330627a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f330627a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(((p0) r100).f330784a, ((p0) r101).f330784a);
    }
}

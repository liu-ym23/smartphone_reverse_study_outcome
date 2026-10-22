package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class o0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f313711a;

    public o0(n0 r100) {
        this.f313711a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f313711a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(((l0) r100).getKey(), ((l0) r101).getKey());
    }
}

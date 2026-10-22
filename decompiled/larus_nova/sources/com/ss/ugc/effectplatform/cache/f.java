package com.ss.ugc.effectplatform.cache;

import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f457334a;

    public f(Map r100) {
        this.f457334a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Pair r102 = (Pair) this.f457334a.get((String) r101);
        Long r103 = null;
        if (r102 == null) goto L5;
        Long r104 = (Long) r102.getSecond();
    L6:
        Pair r105 = (Pair) this.f457334a.get((String) r100);
        if (r105 == null) goto L10;
        r103 = (Long) r105.getSecond();
    L10:
        return ComparisonsKt.compareValues(r104, r103);
    L5:
        r104 = null;
        goto L6
    }
}

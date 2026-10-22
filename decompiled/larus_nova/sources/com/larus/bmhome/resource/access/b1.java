package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b1<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f313625a;

    public b1(a1 r100) {
        this.f313625a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f313625a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(((ResourceUploadSceneResolver) r100).getKey(), ((ResourceUploadSceneResolver) r101).getKey());
    }
}

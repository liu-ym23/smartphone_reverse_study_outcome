package com.larus.drive.sdk.impl.service;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class m<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f341959a;

    public m(l r100) {
        this.f341959a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f341959a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((String) ((Map.Entry) r100).getKey()).length()), Integer.valueOf(((String) ((Map.Entry) r101).getKey()).length()));
    }
}

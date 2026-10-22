package com.larus.drive.sdk.impl.service;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class l<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f341958a;

    public l(k r100) {
        this.f341958a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(k.g(this.f341958a, (String) ((Map.Entry) r100).getKey())), Integer.valueOf(k.g(this.f341958a, (String) ((Map.Entry) r101).getKey())));
    }
}

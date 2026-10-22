package com.f.android.quality.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Scene.b) r100).f274078b), Long.valueOf(((Scene.b) r101).f274078b));
    }
}

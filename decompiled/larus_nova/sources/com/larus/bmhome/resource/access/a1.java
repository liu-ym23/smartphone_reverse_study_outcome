package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a1<T> implements Comparator {
    public a1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ((ResourceUploadSceneResolver) r100).getPriority();
        ((ResourceUploadSceneResolver) r101).getPriority();
        return ComparisonsKt.compareValues(0, 0);
    }
}

package com.bytedance.locallife.dito.core;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class x<T> implements Comparator<T> {
    public x() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ConcurrentLinkedQueue r102 = (ConcurrentLinkedQueue) ((Map.Entry) r100).getValue();
        v.a r103 = null;
        if (r102.size() <= 0) goto L5;
        v.a r104 = (v.a) CollectionsKt.last(r102);
    L6:
        long r105 = 0;
        if (r104 == null) goto L9;
        long r106 = r104.f257998c;
    L10:
        Long r107 = Long.valueOf(r106);
        ConcurrentLinkedQueue r108 = (ConcurrentLinkedQueue) ((Map.Entry) r101).getValue();
        if (r108.size() <= 0) goto L13;
        r103 = (v.a) CollectionsKt.last(r108);
    L13:
        if (r103 == null) goto L16;
        r105 = r103.f257998c;
    L16:
        return ComparisonsKt.compareValues(r107, Long.valueOf(r105));
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}

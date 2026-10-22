package com.ss.android.lark.ug.scheduler.coordinator.entity;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        c r102 = (c) r101;
        c r103 = (c) r100;
        return ComparisonsKt.compareValues(Integer.valueOf((r102.f444496o + (r102.f444491j << 16)) + r102.f444492k), Integer.valueOf((r103.f444496o + (r103.f444491j << 16)) + r103.f444492k));
    }
}

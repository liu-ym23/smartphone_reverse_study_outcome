package com.ss.android.lark.officesdk.launcher;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class f<T> implements Comparator {
    public f() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((mm4.a) r100).getPriority()), Integer.valueOf(((mm4.a) r101).getPriority()));
    }
}

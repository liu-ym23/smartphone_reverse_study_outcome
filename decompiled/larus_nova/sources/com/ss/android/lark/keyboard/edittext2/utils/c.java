package com.ss.android.lark.keyboard.edittext2.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((Integer[]) r100)[0], ((Integer[]) r101)[0]);
    }
}

package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class j<T> implements Comparator {
    public j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r100).getSecond(), (Integer) ((Triple) r101).getSecond());
    }
}

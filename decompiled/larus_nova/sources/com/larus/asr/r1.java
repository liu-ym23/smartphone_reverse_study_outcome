package com.larus.asr;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class r1<T> implements Comparator {
    public r1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r100).lastModified()), Long.valueOf(((File) r101).lastModified()));
    }
}

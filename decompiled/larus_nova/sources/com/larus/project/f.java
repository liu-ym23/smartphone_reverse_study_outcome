package com.larus.project;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f<T> implements Comparator {
    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.larus.bmhome.taskskill.service.h) r101).f314445a.displayOrder), Integer.valueOf(((com.larus.bmhome.taskskill.service.h) r100).f314445a.displayOrder));
    }
}

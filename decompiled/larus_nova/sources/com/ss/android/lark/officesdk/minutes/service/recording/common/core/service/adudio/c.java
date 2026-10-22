package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r100).lastModified()), Long.valueOf(((File) r101).lastModified()));
    }
}

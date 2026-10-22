package com.bytedance.android.livesdk.ktvimpl.mv;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Comparator<T> {
    public r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r4).lastModified()), Long.valueOf(((File) r3).lastModified()));
    }
}

package com.larus.im.internal.core.message.concat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((com.larus.im.bean.message.c) r100).f347106c, ((com.larus.im.bean.message.c) r101).f347106c);
    }
}

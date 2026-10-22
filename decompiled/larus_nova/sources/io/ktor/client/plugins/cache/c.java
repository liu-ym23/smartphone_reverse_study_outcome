package io.ktor.client.plugins.cache;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((b) r101).f491681c.c(), ((b) r100).f491681c.c());
    }
}

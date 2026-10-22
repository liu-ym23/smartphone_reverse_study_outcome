package zb9;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class q<T> implements Comparator {
    public q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Boolean.valueOf(((i) r101).f571192e), Boolean.valueOf(((i) r100).f571192e));
    }
}

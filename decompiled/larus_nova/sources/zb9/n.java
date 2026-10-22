package zb9;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class n<T> implements Comparator {
    public n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((i) r101).f571189b), Long.valueOf(((i) r100).f571189b));
    }
}

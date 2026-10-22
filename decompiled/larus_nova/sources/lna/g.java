package lna;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class g<T> implements Comparator {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Number) ((Pair) r101).component2()).longValue()), Long.valueOf(((Number) ((Pair) r100).component2()).longValue()));
    }
}

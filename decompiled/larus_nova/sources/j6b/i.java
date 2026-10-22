package j6b;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Comparable) ((Pair) r100).getSecond(), (Comparable) ((Pair) r101).getSecond());
    }
}

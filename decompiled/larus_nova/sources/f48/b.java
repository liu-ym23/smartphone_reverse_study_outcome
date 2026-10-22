package f48;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ((c) r101).priority();
        ((c) r100).priority();
        return ComparisonsKt.compareValues(0, 0);
    }
}

package t3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class z<T> implements Comparator {
    public z() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((d0) r100).f544267a, ((d0) r101).f544267a);
    }
}

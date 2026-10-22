package dw6;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((c) r100).f470320d), Integer.valueOf(((c) r101).f470320d));
    }
}

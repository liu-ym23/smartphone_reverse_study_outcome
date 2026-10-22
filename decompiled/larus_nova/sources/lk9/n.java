package lk9;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class n<T> implements Comparator {
    public n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((f) r101).f509628a.f509612d, ((f) r100).f509628a.f509612d);
    }
}

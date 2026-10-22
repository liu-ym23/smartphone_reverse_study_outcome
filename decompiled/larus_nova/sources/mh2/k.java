package mh2;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class k<T> implements Comparator<T> {
    public k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((r.b) r100).f513937a), Integer.valueOf(((r.b) r101).f513937a));
    }
}

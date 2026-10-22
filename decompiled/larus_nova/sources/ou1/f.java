package ou1;

import java.util.Comparator;
import ju1.i;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Comparator<T> {
    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((i) r100).c()), Integer.valueOf(((i) r101).c()));
    }
}

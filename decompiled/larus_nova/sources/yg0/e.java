package yg0;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((Number) r100).intValue()), Integer.valueOf(((Number) r101).intValue()));
    }
}

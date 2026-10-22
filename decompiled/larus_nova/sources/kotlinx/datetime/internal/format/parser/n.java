package kotlinx.datetime.internal.format.parser;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class n<T> implements Comparator {
    public n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((k) r101).f505332a), Integer.valueOf(((k) r100).f505332a));
    }
}

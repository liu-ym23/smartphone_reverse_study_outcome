package q70;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((i70.a) r100).getLayerIndex(), ((i70.a) r101).getLayerIndex());
    }
}

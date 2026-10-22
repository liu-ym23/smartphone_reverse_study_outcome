package k0c;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((b.C6497b) ((Map.Entry) r101).getValue()).f501308d), Long.valueOf(((b.C6497b) ((Map.Entry) r100).getValue()).f501308d));
    }
}

package jq8;

import com.larus.bmhome.interactionpanel.p;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((p) r101).f312396d), Long.valueOf(((p) r100).f312396d));
    }
}

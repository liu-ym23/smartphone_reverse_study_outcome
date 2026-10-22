package v3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Double r102 = ((e) r101).f552790d;
        double r103 = -1.0d;
        if (r102 == null) goto L5;
        double r104 = r102.doubleValue();
    L6:
        Double r105 = Double.valueOf(r104);
        Double r106 = ((e) r100).f552790d;
        if (r106 == null) goto L10;
        r103 = r106.doubleValue();
    L10:
        return ComparisonsKt.compareValues(r105, Double.valueOf(r103));
    L5:
        r104 = -1.0d;
        goto L6
    }
}

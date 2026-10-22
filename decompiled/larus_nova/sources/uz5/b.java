package uz5;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Object r102 = ((Map) r100).get("event_time_stamp");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r104 = (String) r102;
        Object r105 = ((Map) r101).get("event_time_stamp");
        if ((r105 instanceof String) == false) goto L10;
        r103 = r105;
    L10:
        return ComparisonsKt.compareValues(r104, (String) r103);
    }
}

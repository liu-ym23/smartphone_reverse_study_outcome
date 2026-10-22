package of3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final Map<String, LinkedList<a>> a;

    public final void a() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator r1 = ((Iterable) ((Map.Entry) r0.next()).getValue()).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ((a) r1.next()).b.release();
        goto L7
    L9:
        ((LinkedHashMap) this.a).clear();
    }

    public b() {
        this.a = new LinkedHashMap();
    }
}

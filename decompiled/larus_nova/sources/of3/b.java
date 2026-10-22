package of3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, LinkedList<a>> f523074a;

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f523074a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Iterator r101 = ((Iterable) ((Map.Entry) r100.next()).getValue()).iterator();
    L7:
        if (r101.hasNext() == false) goto L4;
        ((a) r101.next()).f523073b.release();
        goto L7
    L9:
        ((LinkedHashMap) this.f523074a).clear();
    }

    public b() {
        this.f523074a = new LinkedHashMap();
    }
}

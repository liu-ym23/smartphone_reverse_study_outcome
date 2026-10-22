package lh3;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    static {
    }

    public static g a(long r4) {
        j r0 = b.a();
        if (r0 == null) goto L14;
        List<g> r1 = r0.b();
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        g r3 = (g) r2.next();
        List<Long> r5 = r3.d();
        if (r5 == null) goto L8;
        if (r5.contains(Long.valueOf(r4)) == false) goto L8;
        return r3;
    L23:
        return null;
    L22:
        return null;
    L14:
        return null;
    }
}

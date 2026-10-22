package lh3;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class h {
    static {
    }

    public static g a(long r100) {
        j r101 = b.a();
        if (r101 == null) goto L14;
        List<g> r102 = r101.b();
        if (r102 == null) goto L22;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L23;
        g r104 = (g) r103.next();
        List<Long> r105 = r104.d();
        if (r105 == null) goto L8;
        if (r105.contains(Long.valueOf(r100)) == false) goto L8;
        return r104;
    L23:
        return null;
    L22:
        return null;
    L14:
        return null;
    }
}

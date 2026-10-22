package tsc;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a0 {
    public a0() {
    }

    public abstract void a(lsc.m r100, v r101, l r102);

    public CharSequence b(m r100, g r101) {
        return null;
    }

    public abstract Collection<String> c();

    public static void d(lsc.m r100, v r101, l.a r102) {
        Iterator<l.a> r103 = r102.children().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        l.a r104 = r103.next();
        if (r104.isClosed() == false) goto L4;
        a0 r105 = r101.b(r104.name());
        if (r105 != null) goto L10;
        d(r100, r101, r104);
        goto L4
    L10:
        r105.a(r100, r101, r104);
        goto L4
    }
}

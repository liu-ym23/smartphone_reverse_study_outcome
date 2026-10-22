package jf3;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements a {
    public final Set<a> a;

    @Override // jf3.a
    public final void p() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).p();
        goto L4
    }

    public e() {
        this.a = new LinkedHashSet();
    }
}

package jf3;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<a> f498879a;

    @Override // jf3.a
    public final void p() {
        Iterator<T> r100 = this.f498879a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).p();
        goto L4
    }

    public e() {
        this.f498879a = new LinkedHashSet();
    }
}

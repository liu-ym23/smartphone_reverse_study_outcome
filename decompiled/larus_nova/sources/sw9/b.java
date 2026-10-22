package sw9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements pw9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<pw9.d> f543729a;

    public b() {
        this.f543729a = new CopyOnWriteArrayList();
    }

    @Override // pw9.d
    public final void P(boolean r100) {
        Iterator<T> r101 = this.f543729a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((pw9.d) r101.next()).P(r100);
        goto L4
    }

    @Override // pw9.d
    public final void b(String r100) {
        Iterator<T> r101 = this.f543729a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((pw9.d) r101.next()).b(r100);
        goto L4
    }

    @Override // pw9.d
    public final void a(String r100, String r101, Integer r102) {
        Iterator<pw9.d> r103 = this.f543729a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().a(r100, r101, r102);
        goto L4
    }
}

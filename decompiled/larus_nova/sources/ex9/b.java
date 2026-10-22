package ex9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements ax9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<ax9.d> f474725a;

    public b() {
        this.f474725a = new CopyOnWriteArrayList();
    }

    @Override // ax9.d
    public final void P(boolean r100) {
        Iterator<T> r101 = this.f474725a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ax9.d) r101.next()).P(r100);
        goto L4
    }

    @Override // ax9.d
    public final void Q(String r100) {
        Iterator<T> r101 = this.f474725a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ax9.d) r101.next()).Q(r100);
        goto L4
    }
}

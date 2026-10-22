package mx6;

import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements xl4.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f516262a;

    @Override // xl4.a.d
    public final void bubbleDismiss() {
        Iterator<T> r100 = this.f516262a.f516249e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a.b) r100.next()).update(0);
        goto L4
    }

    public d(a r100) {
        this.f516262a = r100;
    }
}

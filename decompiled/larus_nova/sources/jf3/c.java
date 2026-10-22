package jf3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f498876a;

    @Override // jf3.b
    public final void c() {
        Iterator<T> r100 = this.f498876a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).c();
        goto L4
    }

    @Override // jf3.b
    public final void d() {
        Iterator<T> r100 = this.f498876a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).d();
        goto L4
    }

    @Override // jf3.b
    public final void e() {
        Iterator<T> r100 = this.f498876a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).e();
        goto L4
    }

    @Override // jf3.b
    public final void f() {
        Iterator<T> r100 = this.f498876a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).f();
        goto L4
    }

    @Override // jf3.b
    public final void g() {
        Iterator<T> r100 = this.f498876a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).g();
        goto L4
    }

    public c() {
        this.f498876a = new CopyOnWriteArrayList();
    }

    @Override // jf3.b
    public final void a(boolean r100) {
        Iterator<T> r101 = this.f498876a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).a(r100);
        goto L4
    }

    @Override // jf3.b
    public final void b(boolean r100) {
        Iterator<T> r101 = this.f498876a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).b(r100);
        goto L4
    }

    public final void h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeCycle");
        this.f498876a.remove(r100);
    }
}

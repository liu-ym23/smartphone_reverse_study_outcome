package jf3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements b {
    public final CopyOnWriteArrayList<b> a;

    @Override // jf3.b
    public final void c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c();
        goto L4
    }

    @Override // jf3.b
    public final void d() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).d();
        goto L4
    }

    @Override // jf3.b
    public final void e() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).e();
        goto L4
    }

    @Override // jf3.b
    public final void f() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).f();
        goto L4
    }

    @Override // jf3.b
    public final void g() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).g();
        goto L4
    }

    public c() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // jf3.b
    public final void a(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a(r3);
        goto L4
    }

    @Override // jf3.b
    public final void b(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b(r3);
        goto L4
    }

    public final void h(b r2) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycle");
        this.a.remove(r2);
    }
}

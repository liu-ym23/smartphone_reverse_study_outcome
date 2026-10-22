package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class p<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = null;
    private volatile /* synthetic */ Object _cur$volatile;

    static {
        a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur$volatile");
    }

    public final void b() {
        AtomicReferenceFieldUpdater r0 = a;
    L3:
        q r1 = (q) r0.get(this);
        if (r1.b() == true) goto L5;
        AtomicReferenceFieldUpdater r2 = a;
        q<E> r3 = r1.c();
    L8:
        if (r2.compareAndSet(this, r1, r3) == true) goto L3;
        if (r2.get(this) == r1) goto L8;
    }

    public final int c() {
        q r0 = (q) a.get(this);
        r0.getClass();
        long r1 = q.f.get(r0);
        int r3 = (int) ((1073741823 & r1) >> 0);
        return 1073741823 & (((int) ((r1 & 1152921503533105152L) >> 30)) - r3);
    }

    public final E d() {
        AtomicReferenceFieldUpdater r0 = a;
    L3:
        q r1 = (q) r0.get(this);
        E r2 = (E) r1.d();
        if (r2 != q.g) goto L5;
        AtomicReferenceFieldUpdater r3 = a;
        q<E> r4 = r1.c();
    L8:
        if (r3.compareAndSet(this, r1, r4) == true) goto L3;
        if (r3.get(this) == r1) goto L8;
    L5:
        return r2;
    }

    public p() {
        this._cur$volatile = new q(8, false);
    }

    public final boolean a(E r6) {
        AtomicReferenceFieldUpdater r0 = a;
    L3:
        q r1 = (q) r0.get(this);
        int r2 = r1.a(r6);
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L7;
        AtomicReferenceFieldUpdater r3 = a;
        q<E> r4 = r1.c();
    L13:
        if (r3.compareAndSet(this, r1, r4) == true) goto L3;
        if (r3.get(this) == r1) goto L13;
    L7:
        if (r2 != 2) goto L3;
        return false;
    L18:
        return true;
    }
}

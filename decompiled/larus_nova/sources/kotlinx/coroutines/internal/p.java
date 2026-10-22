package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class p<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504971a = null;
    private volatile /* synthetic */ Object _cur$volatile;

    static {
        f504971a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur$volatile");
    }

    public final void b() {
        AtomicReferenceFieldUpdater r100 = f504971a;
    L3:
        q r101 = (q) r100.get(this);
        if (r101.b() == true) goto L5;
        AtomicReferenceFieldUpdater r102 = f504971a;
        q<E> r103 = r101.c();
    L8:
        if (r102.compareAndSet(this, r101, r103) == true) goto L3;
        if (r102.get(this) == r101) goto L8;
    }

    public final int c() {
        q r100 = (q) f504971a.get(this);
        r100.getClass();
        long r101 = q.f504973f.get(r100);
        int r102 = (int) ((1073741823 & r101) >> 0);
        return 1073741823 & (((int) ((r101 & 1152921503533105152L) >> 30)) - r102);
    }

    public final E d() {
        AtomicReferenceFieldUpdater r100 = f504971a;
    L3:
        q r101 = (q) r100.get(this);
        E r102 = (E) r101.d();
        if (r102 != q.f504974g) goto L5;
        AtomicReferenceFieldUpdater r103 = f504971a;
        q<E> r104 = r101.c();
    L8:
        if (r103.compareAndSet(this, r101, r104) == true) goto L3;
        if (r103.get(this) == r101) goto L8;
    L5:
        return r102;
    }

    public p() {
        this._cur$volatile = new q(8, false);
    }

    public final boolean a(E r100) {
        AtomicReferenceFieldUpdater r101 = f504971a;
    L3:
        q r102 = (q) r101.get(this);
        int r103 = r102.a(r100);
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L7;
        AtomicReferenceFieldUpdater r104 = f504971a;
        q<E> r105 = r102.c();
    L13:
        if (r104.compareAndSet(this, r102, r105) == true) goto L3;
        if (r104.get(this) == r102) goto L13;
    L7:
        if (r103 != 2) goto L3;
        return false;
    L18:
        return true;
    }
}

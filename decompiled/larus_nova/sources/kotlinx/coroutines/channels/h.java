package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: classes5.dex */
public final class h<E> extends y<h<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BufferedChannel<E> f504699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f504700f;

    @Override // kotlinx.coroutines.internal.y
    public final int g() {
        return e.f504677b;
    }

    public final Object l(int r100) {
        return this.f504700f.get((r100 * 2) + 1);
    }

    @Override // kotlinx.coroutines.internal.y
    public final void h(int r100, CoroutineContext r101) {
        int r102 = e.f504677b;
        if (r100 < r102) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r100 = r100 - r102;
    L8:
        Object r104 = this.f504700f.get(r100 * 2);
    L9:
        Object r105 = l(r100);
        if ((r105 instanceof d2) == true) goto L41;
        if ((r105 instanceof n) == true) goto L41;
        if (r105 == e.f504685j) goto L35;
        if (r105 == e.f504686k) goto L35;
        if (r105 == e.f504682g) goto L9;
        if (r105 == e.f504681f) goto L9;
        if (r105 != e.f504684i) goto L27;
        return;
    L27:
        if (r105 != e.f504679d) goto L30;
        return;
    L30:
        if (r105 != e.f504687l) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r105).toString());
    L35:
        n(r100, null);
        if (r103 == false) goto L65;
        BufferedChannel<E> r106 = this.f504699e;
        Intrinsics.checkNotNull(r106);
        Function1<E, Unit> r107 = r106.f504662b;
        if (r107 == null) goto L66;
        OnUndeliveredElementKt.b(r107, r104, r101);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r103 == false) goto L43;
        b0 r108 = e.f504685j;
    L45:
        if (k(r100, r105, r108) == false) goto L9;
        n(r100, null);
        m(r100, !r103);
        if (r103 == false) goto L67;
        BufferedChannel<E> r109 = this.f504699e;
        Intrinsics.checkNotNull(r109);
        Function1<E, Unit> r110 = r109.f504662b;
        if (r110 == null) goto L68;
        OnUndeliveredElementKt.b(r110, r104, r101);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r108 = e.f504686k;
        goto L45
    L5:
        r103 = false;
        goto L6
    }

    public final void m(int r100, boolean r101) {
        if (r101 == false) goto L4;
        BufferedChannel<E> r102 = this.f504699e;
        Intrinsics.checkNotNull(r102);
        r102.M((this.f504984c * ((long) e.f504677b)) + ((long) r100));
    L4:
        i();
    }

    public final void n(int r100, Object r101) {
        this.f504700f.set(r100 * 2, r101);
    }

    public final void o(int r100, b0 r101) {
        this.f504700f.set((r100 * 2) + 1, r101);
    }

    public final boolean k(int r100, Object r101, Object r102) {
        AtomicReferenceArray r103 = this.f504700f;
        int r104 = (r100 * 2) + 1;
    L4:
        if (r103.compareAndSet(r104, r101, r102) == true) goto L13;
        if (r103.get(r104) == r101) goto L4;
        return false;
    L13:
        return true;
    }

    public h(long r100, h<E> r101, BufferedChannel<E> r102, int r103) {
        super(r100, r101, r103);
        this.f504699e = r102;
        this.f504700f = new AtomicReferenceArray(e.f504677b * 2);
    }
}

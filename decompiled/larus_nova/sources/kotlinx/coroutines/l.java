package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public final class l {
    public static final <T> j<T> a(Continuation<? super T> r100) {
        boolean r101 = true;
        if ((r100 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r102 = (kotlinx.coroutines.internal.i) r100;
        r102.getClass();
        AtomicReferenceFieldUpdater r103 = kotlinx.coroutines.internal.i.f504951h;
    L7:
        Object r104 = r103.get(r102);
        j<T> r105 = null;
        if (r104 == null) goto L9;
        if ((r104 instanceof j) == true) goto L12;
        if (r104 == kotlinx.coroutines.internal.j.f504961b) goto L7;
        if ((r104 instanceof Throwable) == true) goto L7;
        throw new IllegalStateException(("Inconsistent state " + r104).toString());
    L12:
        AtomicReferenceFieldUpdater r106 = kotlinx.coroutines.internal.i.f504951h;
        kotlinx.coroutines.internal.b0 r107 = kotlinx.coroutines.internal.j.f504961b;
    L14:
        if (r106.compareAndSet(r102, r104, r107) == true) goto L15;
        if (r106.get(r102) == r104) goto L14;
        boolean r108 = false;
    L19:
        if (r108 == false) goto L7;
        j<T> r109 = (j) r104;
    L21:
        if (r109 == null) goto L34;
        AtomicReferenceFieldUpdater r110 = j.f504986g;
        Object r111 = r110.get(r109);
        if ((r111 instanceof s) == true) goto L25;
    L27:
        j.f504985f.set(r109, 536870911);
        r110.set(r109, b.f504630a);
    L28:
        if (r101 == false) goto L30;
        r105 = r109;
    L30:
        if (r105 == null) goto L34;
        return r105;
    L25:
        if (((s) r111).f505058d == null) goto L27;
        r109.y();
        r101 = false;
    L34:
        return new j(r100, 2);
    L15:
        r108 = true;
        goto L19
    L9:
        kotlinx.coroutines.internal.i.f504951h.set(r102, kotlinx.coroutines.internal.j.f504961b);
        r109 = null;
        goto L21
    L5:
        return new j(r100, 1);
    }

    public static final <T> void b(i<? super T> r100, h r101) {
        if ((r100 instanceof j) == false) goto L7;
        ((j) r100).E(r101);
        return;
    L7:
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}

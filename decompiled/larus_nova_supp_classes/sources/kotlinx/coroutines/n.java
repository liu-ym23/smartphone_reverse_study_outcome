package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n extends d1 {
    public final j<?> e;

    public n(j<?> r1) {
        this.e = r1;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r9) {
        j<?> r10 = this.e;
        Throwable r0 = r10.A(i());
        boolean r2 = false;
        if (r10.F() == false) goto L28;
        Continuation<?> r1 = r10.d;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.i r3 = (kotlinx.coroutines.internal.i) r1;
        r3.getClass();
        AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.i.h;
    L6:
        Object r5 = r4.get(r3);
        b0 r6 = kotlinx.coroutines.internal.j.b;
        boolean r7 = true;
        if (Intrinsics.areEqual(r5, r6) == true) goto L8;
        if ((r5 instanceof Throwable) == true) goto L19;
        AtomicReferenceFieldUpdater r8 = kotlinx.coroutines.internal.i.h;
    L22:
        if (r8.compareAndSet(r3, r5, null) == true) goto L27;
        if (r8.get(r3) == r5) goto L22;
        r7 = false;
    L27:
        if (r7 == false) goto L6;
    L19:
        r2 = true;
        goto L28
    L8:
        AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.internal.i.h;
    L10:
        if (r11.compareAndSet(r3, r6, r0) == true) goto L11;
        if (r11.get(r3) == r6) goto L10;
        boolean r12 = false;
    L15:
        if (r12 == false) goto L6;
    L11:
        r12 = true;
    L28:
        if (r2 == true) goto L49;
        r10.cancel(r0);
        if (r10.F() == true) goto L48;
        r10.y();
        return;
    L48:
        return;
    }
}

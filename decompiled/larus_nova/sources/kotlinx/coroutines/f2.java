package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class f2 {
    public static final Object a(Continuation<? super Unit> r100) {
        CoroutineContext r101 = r100.getContext();
        JobKt.ensureActive(r101);
        Continuation r102 = IntrinsicsKt.intercepted(r100);
        if ((r102 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r103 = (kotlinx.coroutines.internal.i) r102;
    L6:
        if (r103 != null) goto L8;
        Object r104 = Unit.INSTANCE;
    L39:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L42:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L45;
        return r104;
    L45:
        return Unit.INSTANCE;
    L8:
        boolean r105 = true;
        if (r103.f504952d.isDispatchNeeded(r101) == false) goto L11;
        r103.f504954f = Unit.INSTANCE;
        r103.f504922c = 1;
        r103.f504952d.dispatchYield(r101, r103);
    L37:
        r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L39
    L11:
        e2 r106 = new e2();
        CoroutineContext r107 = r101.plus(r106);
        Unit r108 = Unit.INSTANCE;
        r103.f504954f = r108;
        r103.f504922c = 1;
        r103.f504952d.dispatchYield(r107, r103);
        if (r106.f504738a == false) goto L37;
        kotlinx.coroutines.internal.b0 r109 = kotlinx.coroutines.internal.j.f504960a;
        q0 r110 = v1.a();
        ArrayDeque<i0<?>> r111 = r110.f505006c;
        if (r111 == null) goto L16;
        boolean r112 = r111.isEmpty();
    L17:
        if (r112 == false) goto L20;
    L30:
        r105 = false;
    L31:
        if (r105 == false) goto L33;
        r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L39
    L33:
        r104 = Unit.INSTANCE;
        goto L39
    L20:
        if (r110.l() == false) goto L22;
        r103.f504954f = r108;
        r103.f504922c = 1;
        r110.h(r103);
        goto L31
    L22:
        r110.i(true);
        r103.run();     // Catch: Throwable -> L27
    L24:
        if (r110.n() == true) goto L24;
    L29:
        r110.d(true);
    L27:
        th = move-exception;
        r103.o(th, null);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r110.d(true);
        throw th;
    L16:
        r112 = true;
        goto L17
    L5:
        r103 = null;
        goto L6
    }
}

package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f504960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f504961b = null;

    static {
        f504960a = new b0("UNDEFINED");
        f504961b = new b0("REUSABLE_CLAIMED");
    }

    public static final <T> void a(Continuation<? super T> r100, Object r101, Function1<? super Throwable, Unit> r102) {
        if ((r100 instanceof i) == false) goto L48;
        i r103 = (i) r100;
        Throwable r104 = Result.m9452exceptionOrNullimpl(r101);
        boolean r105 = false;
        if (r104 != null) goto L9;
        if (r102 == null) goto L8;
        Object r106 = new kotlinx.coroutines.u(r101, r102);
    L11:
        if (r103.f504952d.isDispatchNeeded(r103.getContext()) == false) goto L13;
        r103.f504954f = r106;
        r103.f504922c = 1;
        r103.f504952d.dispatch(r103.getContext(), r103);
        return;
    L13:
        q0 r107 = v1.a();
        if (r107.l() == false) goto L16;
        r103.f504954f = r106;
        r103.f504922c = 1;
        r107.h(r103);
        return;
    L16:
        r107.i(true);
        Job r108 = (Job) r103.getContext().get(Job.Key);     // Catch: Throwable -> L42
        if (r108 != null) goto L20;
    L22:
        if (r105 == true) goto L40;
        Continuation<T> r109 = r103.f504953e;     // Catch: Throwable -> L42
        Object r110 = r103.f504955g;     // Catch: Throwable -> L42
        CoroutineContext r111 = r109.getContext();     // Catch: Throwable -> L42
        Object r112 = ThreadContextKt.c(r111, r110);     // Catch: Throwable -> L42
        if (r112 == ThreadContextKt.f504930a) goto L27;
        b2<?> r113 = CoroutineContextKt.d(r109, r111, r112);     // Catch: Throwable -> L42
    L50:
        r103.f504953e.resumeWith(r101);     // Catch: Throwable -> L33
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L33
        if (r113 != null) goto L31;
    L32:
        ThreadContextKt.a(r111, r112);     // Catch: Throwable -> L42
        goto L40
    L31:
        if (r113.n0() == false) goto L40;
    L33:
        th = move-exception;
        if (r113 != null) goto L36;
    L37:
        ThreadContextKt.a(r111, r112);     // Catch: Throwable -> L42
    L38:
        throw th;     // Catch: Throwable -> L42
    L36:
        if (r113.n0() == false) goto L38;
    L27:
        r113 = null;
    L40:
        if (r107.n() == true) goto L40;
    L44:
        r107.d(true);
        return;
    L20:
        if (r108.isActive() == true) goto L22;
        CancellationException r115 = r108.getCancellationException();     // Catch: Throwable -> L42
        r103.a(r106, r115);     // Catch: Throwable -> L42
        r103.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r115)));     // Catch: Throwable -> L42
        r105 = true;
    L42:
        th = move-exception;
        r103.o(th, null);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r107.d(true);
        throw th;
    L8:
        r106 = r101;
        goto L11
    L9:
        r106 = new kotlinx.coroutines.t(r104, false);
        goto L11
    L48:
        r100.resumeWith(r101);
    }
}

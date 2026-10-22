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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j {
    public static final b0 a = null;
    public static final b0 b = null;

    static {
        a = new b0("UNDEFINED");
        b = new b0("REUSABLE_CLAIMED");
    }

    public static final <T> void a(Continuation<? super T> r6, Object r7, Function1<? super Throwable, Unit> r8) {
        if ((r6 instanceof i) == false) goto L48;
        i r9 = (i) r6;
        Throwable r0 = Result.m52exceptionOrNullimpl(r7);
        boolean r1 = false;
        if (r0 != null) goto L9;
        if (r8 == null) goto L8;
        Object r2 = new kotlinx.coroutines.u(r7, r8);
    L11:
        if (r9.d.isDispatchNeeded(r9.getContext()) == false) goto L13;
        r9.f = r2;
        r9.c = 1;
        r9.d.dispatch(r9.getContext(), r9);
        return;
    L13:
        q0 r10 = v1.a();
        if (r10.l() == false) goto L16;
        r9.f = r2;
        r9.c = 1;
        r10.h(r9);
        return;
    L16:
        r10.i(true);
        Job r4 = (Job) r9.getContext().get(Job.Key);     // Catch: Throwable -> L42
        if (r4 != null) goto L20;
    L22:
        if (r1 == true) goto L40;
        Continuation<T> r3 = r9.e;     // Catch: Throwable -> L42
        Object r5 = r9.g;     // Catch: Throwable -> L42
        CoroutineContext r11 = r3.getContext();     // Catch: Throwable -> L42
        Object r12 = ThreadContextKt.c(r11, r5);     // Catch: Throwable -> L42
        if (r12 == ThreadContextKt.a) goto L27;
        b2<?> r13 = CoroutineContextKt.d(r3, r11, r12);     // Catch: Throwable -> L42
    L50:
        r9.e.resumeWith(r7);     // Catch: Throwable -> L33
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L33
        if (r13 != null) goto L31;
    L32:
        ThreadContextKt.a(r11, r12);     // Catch: Throwable -> L42
        goto L40
    L31:
        if (r13.n0() == false) goto L40;
    L33:
        th = move-exception;
        if (r13 != null) goto L36;
    L37:
        ThreadContextKt.a(r11, r12);     // Catch: Throwable -> L42
    L38:
        throw th;     // Catch: Throwable -> L42
    L36:
        if (r13.n0() == false) goto L38;
    L27:
        r13 = null;
    L40:
        if (r10.n() == true) goto L40;
    L44:
        r10.d(true);
        return;
    L20:
        if (r4.isActive() == true) goto L22;
        CancellationException r15 = r4.getCancellationException();     // Catch: Throwable -> L42
        r9.a(r2, r15);     // Catch: Throwable -> L42
        r9.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(r15)));     // Catch: Throwable -> L42
        r1 = true;
    L42:
        th = move-exception;
        r9.o(th, null);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r10.d(true);
        throw th;
    L8:
        r2 = r7;
        goto L11
    L9:
        r2 = new kotlinx.coroutines.t(r0, false);
        goto L11
    L48:
        r6.resumeWith(r7);
    }
}

package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import duc.g;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class i0<T> extends g {
    public int c;

    public void a(Object r1, Throwable r2) {
    }

    public abstract Continuation<T> c();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T n(Object r1) {
        return r1;
    }

    public abstract Object s();

    public final void q() {
        duc.h r0 = this.b;
        Continuation<T> r1 = c();     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L42
        kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.i) r1;     // Catch: Throwable -> L42
        Continuation<T> r3 = r2.e;     // Catch: Throwable -> L42
        Object r4 = r2.g;     // Catch: Throwable -> L42
        CoroutineContext r5 = r3.getContext();     // Catch: Throwable -> L42
        Object r6 = ThreadContextKt.c(r5, r4);     // Catch: Throwable -> L42
        if (r6 == ThreadContextKt.a) goto L7;
        b2<?> r7 = CoroutineContextKt.d(r3, r5, r6);     // Catch: Throwable -> L42
    L54:
        CoroutineContext r8 = r3.getContext();     // Catch: Throwable -> L36
        Object r9 = s();     // Catch: Throwable -> L36
        Throwable r10 = g(r9);     // Catch: Throwable -> L36
        if (r10 != null) goto L18;
        int r11 = this.c;     // Catch: Throwable -> L36
        boolean r12 = true;
        if (r11 != 1) goto L13;
    L16:
        if (r12 == false) goto L18;
        Job r13 = (Job) r8.get(Job.Key);     // Catch: Throwable -> L36
    L19:
        if (r13 != null) goto L21;
    L23:
        if (r10 == null) goto L25;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L36
        r3.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(r10)));     // Catch: Throwable -> L36
    L26:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L36
        if (r7 != null) goto L29;
    L30:
        ThreadContextKt.a(r5, r6);     // Catch: Throwable -> L42
    L51:
        r0.a();     // Catch: Throwable -> L33
        Object r16 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        o(null, Result.m52exceptionOrNullimpl(r16));
        return;
    L33:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L35
    L29:
        if (r7.n0() == false) goto L51;
    L25:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L36
        r3.resumeWith(Result.m49constructorimpl(n(r9)));     // Catch: Throwable -> L36
        goto L26
    L21:
        if (r13.isActive() == true) goto L23;
        CancellationException r19 = r13.getCancellationException();     // Catch: Throwable -> L36
        a(r9, r19);     // Catch: Throwable -> L36
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L36
        r3.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(r19)));     // Catch: Throwable -> L36
        goto L26
    L13:
        if (r11 == 2) goto L16;
        r12 = false;
    L18:
        r13 = null;
    L36:
        th = move-exception;
        if (r7 != null) goto L39;
    L40:
        ThreadContextKt.a(r5, r6);     // Catch: Throwable -> L42
    L41:
        throw th;     // Catch: Throwable -> L42
    L39:
        if (r7.n0() == false) goto L41;
    L7:
        r7 = null;
    L42:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L45
        r0.a();     // Catch: Throwable -> L45
        Object r22 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        o(th, Result.m52exceptionOrNullimpl(r22));
        return;
    L45:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r22 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L47
    }

    @Override // java.lang.Runnable
    public final void run() {
        q();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i0(int r1) {
        this.c = r1;
    }

    public Throwable g(Object r3) {
        if ((r3 instanceof t) == false) goto L5;
        t r4 = (t) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.a;
    L5:
        r4 = null;
        goto L6
    }

    public final void o(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        ExceptionsKt.addSuppressed(r3, r4);
    L8:
        if (r3 != null) goto L10;
        r3 = r4;
    L10:
        Intrinsics.checkNotNull(r3);
        y.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3));
    }
}

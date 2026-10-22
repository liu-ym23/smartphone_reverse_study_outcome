package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j0 {
    public static final <T> void a(i0<? super T> r3, Continuation<? super T> r4, boolean r5) {
        Object r0 = r3.s();
        Throwable r1 = r3.g(r0);
        if (r1 == null) goto L5;
        Result.Companion r6 = Result.Companion;
        Object r7 = ResultKt.createFailure(r1);
    L6:
        Object r8 = Result.m49constructorimpl(r7);
        if (r5 == false) goto L23;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.i r9 = (kotlinx.coroutines.internal.i) r4;
        Continuation<T> r10 = r9.e;
        Object r2 = r9.g;
        CoroutineContext r11 = r10.getContext();
        Object r12 = ThreadContextKt.c(r11, r2);
        if (r12 == ThreadContextKt.a) goto L11;
        b2<?> r13 = CoroutineContextKt.d(r10, r11, r12);
    L25:
        r9.e.resumeWith(r8);     // Catch: Throwable -> L17
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r13 != null) goto L15;
    L16:
        ThreadContextKt.a(r11, r12);
        return;
    L15:
        if (r13.n0() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r13 != null) goto L20;
    L21:
        ThreadContextKt.a(r11, r12);
    L22:
        throw th;
    L20:
        if (r13.n0() == false) goto L22;
    L11:
        r13 = null;
        goto L25
    L23:
        r4.resumeWith(r8);
        return;
    L5:
        Result.Companion r15 = Result.Companion;
        r7 = r3.n(r0);
        goto L6
    }
}

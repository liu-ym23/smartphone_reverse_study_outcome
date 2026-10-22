package cuc;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final void a(Continuation<? super Unit> r2, Continuation<?> r3) {
        Continuation r4 = IntrinsicsKt.intercepted(r2);     // Catch: Throwable -> L4
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        j.a(r4, Result.m49constructorimpl(Unit.INSTANCE), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }

    public static void b(Function2 r1, Object r2, Continuation r3) {
        Continuation r4 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r1, r2, r3));     // Catch: Throwable -> L4
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        j.a(r4, Result.m49constructorimpl(Unit.INSTANCE), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }
}

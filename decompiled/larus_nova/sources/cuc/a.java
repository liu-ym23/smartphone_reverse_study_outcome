package cuc;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final void a(Continuation<? super Unit> r100, Continuation<?> r101) {
        Continuation r102 = IntrinsicsKt.intercepted(r100);     // Catch: Throwable -> L4
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
        j.a(r102, Result.m9449constructorimpl(Unit.INSTANCE), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }

    public static void b(Function2 r100, Object r101, Continuation r102) {
        Continuation r103 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r100, r101, r102));     // Catch: Throwable -> L4
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
        j.a(r103, Result.m9449constructorimpl(Unit.INSTANCE), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }
}

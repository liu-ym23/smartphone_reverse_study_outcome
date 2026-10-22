package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static final <T, V> Object a(CoroutineContext r100, V r101, Object r102, Function2<? super V, ? super Continuation<? super T>, ? extends Object> r103, Continuation<? super T> r104) {
        Object r105 = ThreadContextKt.c(r100, r102);
        q r106 = new q(r104, r100);     // Catch: Throwable -> L11
        if ((r103 instanceof BaseContinuationImpl) == true) goto L6;
        Object r107 = IntrinsicsKt.wrapWithContinuationImpl(r103, r101, r106);     // Catch: Throwable -> L11
    L7:
        ThreadContextKt.a(r100, r105);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L10:
        return r107;
    L6:
        r107 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r103, 2)).invoke(r101, r106);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ThreadContextKt.a(r100, r105);
        throw th;
    }
}

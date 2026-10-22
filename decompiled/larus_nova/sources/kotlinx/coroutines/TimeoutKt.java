package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class TimeoutKt {
    public static final <U, T extends U> Object a(z1<U, ? super T> r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101) {
        JobKt.disposeOnCompletion(r100, DelayKt.getDelay(r100.f504982d.getContext()).invokeOnTimeout(r100.f505166e, r100, r100.getContext()));
        boolean r102 = false;
    L8:
        th = move-exception;
        Object r103 = new t(th, false);
    L11:
        if (r103 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        Object r104 = r100.V(r103);
        if (r104 != g1.f504913b) goto L17;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L17:
        if ((r104 instanceof t) == false) goto L30;
        Throwable r105 = ((t) r104).f505148a;
        if ((r105 instanceof TimeoutCancellationException) == true) goto L21;
    L22:
        r102 = true;
    L23:
        if (r102 == false) goto L25;
        throw r105;
    L25:
        if ((r103 instanceof t) == false) goto L32;
        throw ((t) r103).f505148a;
    L32:
        return r103;
    L21:
        if (((TimeoutCancellationException) r105).coroutine == r100) goto L23;
    L30:
        r103 = g1.a(r104);
        goto L32
    L36:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        if ((r101 instanceof BaseContinuationImpl) == true) goto L6;
        r103 = IntrinsicsKt.wrapWithContinuationImpl(r101, r100, r100);     // Catch: Throwable -> L8
    L33:
        goto L11
    L6:
        r103 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 2)).invoke(r100, r100);     // Catch: Throwable -> L8
        goto L33
    }

    public static final <T> Object b(long r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        if (r100 <= 0) goto L9;
        Object r103 = a(new z1(r100, r102), r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L7:
        return r103;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.z1] */
    public static final <T> Object c(long r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r110) {
        if ((r110 instanceof TimeoutKt$withTimeoutOrNull$1) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r102 = (TimeoutKt$withTimeoutOrNull$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$1;
        Function2 r107 = (Function2) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: TimeoutCancellationException -> L14
        return r111;
    L14:
        TimeoutCancellationException e100 = e;
    L32:
        if (e100.coroutine != r106.element) goto L34;
        return null;
    L34:
        throw e100;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        if (r100 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r102.L$0 = r101;     // Catch: TimeoutCancellationException -> L29
        r102.L$1 = r112;     // Catch: TimeoutCancellationException -> L29
        r102.J$0 = r100;     // Catch: TimeoutCancellationException -> L29
        r102.label = 1;     // Catch: TimeoutCancellationException -> L29
        ?? r108 = (T) new z1(r100, r102);
        r112.element = r108;     // Catch: TimeoutCancellationException -> L29
        Object r109 = a(r108, r101);     // Catch: TimeoutCancellationException -> L29
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: TimeoutCancellationException -> L29
    L25:
        if (r109 != r104) goto L28;
        return r104;
    L28:
        return r109;
    L29:
        e = move-exception;
        e100 = e;
        r106 = r112;
    L7:
        r102 = new TimeoutKt$withTimeoutOrNull$1(r110);
        goto L8
    }
}

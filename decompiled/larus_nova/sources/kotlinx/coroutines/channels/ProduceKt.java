package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
public final class ProduceKt {
    public static final Object a(k<?> r100, Function0<Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ProduceKt$awaitClose$1) == false) goto L7;
        ProduceKt$awaitClose$1 r103 = (ProduceKt$awaitClose$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        r101 = (Function0) r103.L$1;
        k r108 = (k) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L28:
        r101.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        if (r103.getContext().get(Job.Key) != r100) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L33;
        r103.L$0 = r100;     // Catch: Throwable -> L14
        r103.L$1 = r101;     // Catch: Throwable -> L14
        r103.label = 1;     // Catch: Throwable -> L14
        final kotlinx.coroutines.j r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);     // Catch: Throwable -> L14
        r110.C();     // Catch: Throwable -> L14
        r100.invokeOnClose(new ProduceKt$awaitClose$4$1(r110));     // Catch: Throwable -> L14
        Object r111 = r110.B();     // Catch: Throwable -> L14
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r103);     // Catch: Throwable -> L14
    L26:
        if (r111 != r106) goto L28;
        return r106;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r109 = false;
    L14:
        th = move-exception;
        r101.invoke();
        throw th;
    L7:
        r103 = new ProduceKt$awaitClose$1(r102);
        goto L8
    }

    public static j c(CoroutineScope r100, int r101, Function2 r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        EmptyCoroutineContext r102 = EmptyCoroutineContext.INSTANCE;
    L6:
        EmptyCoroutineContext r103 = r102;
        if ((r111 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        return b(r100, r103, r104, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r110);
    L9:
        r104 = r101;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public static j d(GlobalScope r100, CoroutineContext r101, Function1 r102, Function2 r110) {
        CoroutineStart r103 = CoroutineStart.DEFAULT;
        return b(r100, r101, 0, BufferOverflow.SUSPEND, r103, r102, r110);
    }

    public static final j b(CoroutineScope r100, CoroutineContext r101, int r102, BufferOverflow r103, CoroutineStart r104, Function1 r105, Function2 r106) {
        Channel r107 = ChannelKt.Channel$default(r102, r103, null, 4, null);
        j r108 = new j(CoroutineContextKt.c(r100, r101), r107);
        if (r105 == null) goto L5;
        r108.invokeOnCompletion(r105);
    L5:
        r104.invoke(r106, r108, r108);
        return r108;
    }
}

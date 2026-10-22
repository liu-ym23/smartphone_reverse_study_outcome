package io.ktor.websocket;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketJvm$1", f = "RawWebSocketJvm.kt", i = {2, 3}, l = {67, 68, 71, 74}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
final class RawWebSocketJvm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ i this$0;

    public RawWebSocketJvm$1(i r100, Continuation<? super RawWebSocketJvm$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RawWebSocketJvm$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RawWebSocketJvm$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        throw null;     // Catch: Throwable -> L34
    L5:
        if (r102 == 1) goto L23;
        if (r102 != 2) goto L8;
        ChannelIterator r103 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        this.L$0 = r103;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        this.label = 1;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        r100 = r103.hasNext(this);     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        if (r100 != r101) goto L26;
        return r101;
    L26:
        if (((Boolean) r100).booleanValue() == true) goto L29;
        i r104 = this.this$0;
        KProperty<Object>[] r105 = i.f492179a;
        r104.getClass();
        SendChannel.a.a(null);
        throw null;
    L29:
        c r106 = (c) r103.next();     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        i r107 = this.this$0;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        KProperty<Object>[] r108 = i.f492179a;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        r107.getClass();     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        this.L$0 = r103;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        this.label = 2;     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
        throw null;     // Catch: Throwable -> L34
    L8:
        if (r102 != 3) goto L10;
        FrameTooBigException r109 = (FrameTooBigException) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L42
        i r110 = this.this$0;     // Catch: Throwable -> L42
        KProperty<Object>[] r111 = i.f492179a;     // Catch: Throwable -> L42
        r110.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L10:
        if (r102 != 4) goto L12;
        ProtocolViolationException r112 = (ProtocolViolationException) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L42
        i r113 = this.this$0;     // Catch: Throwable -> L42
        KProperty<Object>[] r114 = i.f492179a;     // Catch: Throwable -> L42
        r113.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        r103 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L34 CancellationException -> L36 ProtocolViolationException -> L38 FrameTooBigException -> L40
    L34:
        i r115 = this.this$0;     // Catch: Throwable -> L42
        KProperty<Object>[] r116 = i.f492179a;     // Catch: Throwable -> L42
        r115.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L42:
        i r117 = this.this$0;
        KProperty<Object>[] r118 = i.f492179a;
        r117.getClass();
        SendChannel.a.a(null);
        throw null;
    L40:
        this.this$0.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L38:
        this.this$0.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L36:
        this.this$0.getClass();     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    }
}

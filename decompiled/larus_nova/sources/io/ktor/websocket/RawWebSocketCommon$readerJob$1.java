package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import java.io.EOFException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", i = {2, 3}, l = {88, 92, 95, 99}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public RawWebSocketCommon$readerJob$1(g r100, Continuation<? super RawWebSocketCommon$readerJob$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RawWebSocketCommon$readerJob$1(null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RawWebSocketCommon$readerJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
    L5:
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
        c r102 = (c) r100;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
        if (r102.f492169b.getControlFrame() == false) goto L24;
        throw null;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
    L24:
        if (r102.f492168a == true) goto L40;
        r102.f492169b.getOpcode();     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
        throw null;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
    L40:
        throw null;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
    L7:
        if (r101 != 2) goto L9;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
        throw null;     // Catch: Throwable -> L31 ChannelIOException -> L32 ClosedReceiveChannelException -> L33 EOFException -> L34 CancellationException -> L35 ProtocolViolationException -> L36 FrameTooBigException -> L37
    L9:
        if (r101 != 3) goto L11;
        FrameTooBigException r103 = (FrameTooBigException) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L11:
        if (r101 != 4) goto L13;
        ProtocolViolationException r104 = (ProtocolViolationException) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L38:
        throw null;
    L32:
        throw null;     // Catch: Throwable -> L38
    L31:
        throw null;     // Catch: Throwable -> L38
    L37:
        throw null;     // Catch: Throwable -> L38
    L35:
        throw null;     // Catch: Throwable -> L38
    L36:
        throw null;     // Catch: Throwable -> L38
    L34:
        throw null;
    L33:
        throw null;
    }
}

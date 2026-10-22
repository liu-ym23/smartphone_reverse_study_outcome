package io.ktor.websocket;

import io.ktor.util.cio.ChannelWriteException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {58, 60}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public RawWebSocketCommon$writerJob$1(g r100, Continuation<? super RawWebSocketCommon$writerJob$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RawWebSocketCommon$writerJob$1(null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RawWebSocketCommon$writerJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;     // Catch: Throwable -> L23 ChannelWriteException -> L24
    L5:
        if (r101 != 1) goto L26;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L23 ChannelWriteException -> L24
        if ((r100 instanceof c) == false) goto L15;
        throw null;     // Catch: Throwable -> L23 ChannelWriteException -> L24
    L15:
        if ((r100 instanceof g.a) == false) goto L19;
        ((g.a) r100).getClass();     // Catch: Throwable -> L23 ChannelWriteException -> L24
        throw null;     // Catch: Throwable -> L23 ChannelWriteException -> L24
    L19:
        throw new IllegalArgumentException("unknown message " + r100);     // Catch: Throwable -> L23 ChannelWriteException -> L24
    L26:
        if (r101 != 2) goto L9;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L23 ChannelWriteException -> L24
        throw null;     // Catch: Throwable -> L23 ChannelWriteException -> L24
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        throw null;
    L24:
        throw null;     // Catch: Throwable -> L25
    L23:
        throw null;     // Catch: Throwable -> L25
    }
}

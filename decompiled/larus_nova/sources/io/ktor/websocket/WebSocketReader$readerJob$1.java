package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"buffer"}, s = {"L$0"})
final class WebSocketReader$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ io.ktor.utils.io.pool.e<ByteBuffer> $pool;
    Object L$0;
    int label;
    final /* synthetic */ WebSocketReader this$0;

    public WebSocketReader$readerJob$1(io.ktor.utils.io.pool.e<ByteBuffer> r100, WebSocketReader r101, Continuation<? super WebSocketReader$readerJob$1> r102) {
        this.$pool = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WebSocketReader$readerJob$1(this.$pool, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WebSocketReader$readerJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to build post-dominance tree
    java.lang.ArrayIndexOutOfBoundsException: Index 37 out of bounds for length 37
    	at jadx.core.dex.visitors.blocks.DominatorTree.build(DominatorTree.java:68)
    	at jadx.core.dex.visitors.blocks.PostDominatorTree.compute(PostDominatorTree.java:32)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:93)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        ByteBuffer r103 = (ByteBuffer) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8 ProtocolViolationException -> L33 FrameTooBigException -> L34 ChannelIOException -> L35 Throwable -> L36
    L8:
        Throwable th10 = th;
    L18:
        throw th10;     // Catch: Throwable -> L28
    L26:
        this.this$0.getClass();     // Catch: Throwable -> L28
        throw null;     // Catch: Throwable -> L28
    L23:
        this.this$0.getClass();     // Catch: Throwable -> L28
        throw null;     // Catch: Throwable -> L28
    L20:
        this.this$0.getClass();     // Catch: Throwable -> L28
        throw null;     // Catch: Throwable -> L28
    L31:
        this.$pool.Rl(r103);
        this.this$0.getClass();
        SendChannel.a.a(null);
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        ByteBuffer r104 = this.$pool.Q5();
        WebSocketReader r105 = this.this$0;     // Catch: Throwable -> L16 ProtocolViolationException -> L19 FrameTooBigException -> L22 ChannelIOException -> L25 Throwable -> L37
        this.L$0 = r104;     // Catch: Throwable -> L16 ProtocolViolationException -> L19 FrameTooBigException -> L22 ChannelIOException -> L25 Throwable -> L37
        this.label = 1;     // Catch: Throwable -> L16 ProtocolViolationException -> L19 FrameTooBigException -> L22 ChannelIOException -> L25 Throwable -> L37
        if (WebSocketReader.a(r105, r104, this) != r101) goto L30;
        return r101;
    L16:
        th = move-exception;
        th10 = th;
    L30:
        r103 = r104;
    L28:
        this.$pool.Rl((ByteBuffer) r101);
        this.this$0.getClass();
        SendChannel.a.a(null);
        throw null;
    }
}

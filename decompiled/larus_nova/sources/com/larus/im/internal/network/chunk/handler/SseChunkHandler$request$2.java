package com.larus.im.internal.network.chunk.handler;

import com.larus.im.internal.network.chunk.handler.config.ChunkPosition;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lcom/larus/im/internal/protocol/bean/DownlinkMessage;", "", "Lcom/larus/im/internal/network/chunk/handler/config/ChunkPosition;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.handler.SseChunkHandler$request$2", f = "SseChunkHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SseChunkHandler$request$2 extends SuspendLambda implements Function4<DownlinkMessage, String, ChunkPosition, Continuation<? super Boolean>, Object> {
    int label;

    public SseChunkHandler$request$2(Continuation<? super SseChunkHandler$request$2> r100) {
        super(4, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DownlinkMessage r100, String r101, ChunkPosition r102, Continuation<? super Boolean> r103) {
        return new SseChunkHandler$request$2(r103).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(DownlinkMessage r100, String r101, ChunkPosition r102, Continuation<? super Boolean> r103) {
        return invoke2(r100, r101, r102, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

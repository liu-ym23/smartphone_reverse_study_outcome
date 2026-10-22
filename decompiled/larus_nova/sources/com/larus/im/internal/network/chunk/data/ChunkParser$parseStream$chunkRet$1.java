package com.larus.im.internal.network.chunk.data;

import com.larus.im.internal.network.chunk.exception.ReceiveChunkTimeoutException;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/im/internal/network/chunk/data/ChunkPackage;", LynxError.LYNX_THROWABLE, "", "job", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.data.ChunkParser$parseStream$chunkRet$1", f = "ChunkParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChunkParser$parseStream$chunkRet$1 extends SuspendLambda implements Function3<Throwable, Job, Continuation<? super Result<? extends b>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ChunkParser$parseStream$chunkRet$1(Continuation<? super ChunkParser$parseStream$chunkRet$1> r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Throwable r100, Job r101, Continuation<? super Result<? extends b>> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Throwable r100, Job r101, Continuation<? super Result<b>> r102) {
        ChunkParser$parseStream$chunkRet$1 r103 = new ChunkParser$parseStream$chunkRet$1(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        Throwable r101 = (Throwable) this.L$0;
        Job r102 = (Job) this.L$1;
        if ((r101 instanceof TimeoutCancellationException) == false) goto L10;
        String r103 = r101.getMessage();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r101 = new ReceiveChunkTimeoutException(r103, r102);
    L10:
        Result.Companion r104 = Result.Companion;
        return Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

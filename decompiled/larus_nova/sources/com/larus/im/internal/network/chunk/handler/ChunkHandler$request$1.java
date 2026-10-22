package com.larus.im.internal.network.chunk.handler;

import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.handler.ChunkHandler", f = "ChunkHandler.kt", i = {0, 0, 0, 2, 2, 2, 2, 2}, l = {141, 152, 158, 193}, m = "request", n = {"token", "uplinkMessage", "retryParams", "token", "uplinkMessage", "retryParams", "logId", SRStrategy.MEDIAINFO_KEY_BITRATE}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class ChunkHandler$request$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChunkHandler this$0;

    public ChunkHandler$request$1(ChunkHandler r100, Continuation<? super ChunkHandler$request$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ChunkHandler.a(this.this$0, null, null, null, this);
    }
}

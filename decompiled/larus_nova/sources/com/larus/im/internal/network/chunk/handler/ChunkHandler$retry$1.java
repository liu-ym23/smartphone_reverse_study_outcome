package com.larus.im.internal.network.chunk.handler;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.handler.ChunkHandler", f = "ChunkHandler.kt", i = {0, 0, 0, 0}, l = {215}, m = EventConstant.Value.RETRY, n = {"token", "uplinkMessage", "retryParams", "retryTimeLog"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ChunkHandler$retry$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChunkHandler this$0;

    public ChunkHandler$retry$1(ChunkHandler r100, Continuation<? super ChunkHandler$retry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ChunkHandler r101 = this.this$0;
        int r102 = ChunkHandler.f349119e;
        return r101.e(null, null, null, null, this);
    }
}

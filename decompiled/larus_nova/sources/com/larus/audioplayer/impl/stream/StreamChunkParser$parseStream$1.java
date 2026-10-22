package com.larus.audioplayer.impl.stream;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.StreamChunkParser", f = "StreamChunkParser.kt", i = {0, 0, 0, 0, 0}, l = {57, 67}, m = "parseStream", n = {"buffer", "onDataParsed", "needStop", MonitorConstants.CHUNK, DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
public final class StreamChunkParser$parseStream$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamChunkParser this$0;

    public StreamChunkParser$parseStream$1(StreamChunkParser r100, Continuation<? super StreamChunkParser$parseStream$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}

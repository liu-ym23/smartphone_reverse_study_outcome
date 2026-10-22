package com.larus.im.internal.network.sse;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.sse.SseChunkParser", f = "SseChunkParser.kt", i = {0, 0, 1, 1, 1}, l = {37, 65}, m = "parseStream", n = {"buffer", "onDataParsed", "buffer", "onDataParsed", MonitorConstants.CHUNK}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class SseChunkParser$parseStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SseChunkParser this$0;

    public SseChunkParser$parseStream$1(SseChunkParser r100, Continuation<? super SseChunkParser$parseStream$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}

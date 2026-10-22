package com.larus.avlink.activeSummary;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ChunkParser", f = "ChunkParser.kt", i = {0, 0, 0, 0}, l = {38, 45}, m = "parseStream", n = {"readLine", "close", "onDataParsed", MonitorConstants.CHUNK}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ChunkParser$parseStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChunkParser this$0;

    public ChunkParser$parseStream$1(ChunkParser r100, Continuation<? super ChunkParser$parseStream$1> r101) {
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

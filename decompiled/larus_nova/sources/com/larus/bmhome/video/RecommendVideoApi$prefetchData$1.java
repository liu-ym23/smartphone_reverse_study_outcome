package com.larus.bmhome.video;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.RecommendVideoApi", f = "RecommendVideoApi.kt", i = {0, 0}, l = {80}, m = "prefetchData", n = {"sortScene", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0"})
public final class RecommendVideoApi$prefetchData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApi this$0;

    public RecommendVideoApi$prefetchData$1(RecommendVideoApi r100, Continuation<? super RecommendVideoApi$prefetchData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}

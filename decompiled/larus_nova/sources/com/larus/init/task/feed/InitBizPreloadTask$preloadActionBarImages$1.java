package com.larus.init.task.feed;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.init.task.feed.InitBizPreloadTask", f = "InitBizPreloadTask.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {83, 91}, m = "preloadActionBarImages", n = {"imagePipeline", "imageExtra", "iconUrl", "imagePipeline", "imageExtra", "iconUrl", "startTs"}, s = {"L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "J$0"})
final class InitBizPreloadTask$preloadActionBarImages$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitBizPreloadTask this$0;

    public InitBizPreloadTask$preloadActionBarImages$1(InitBizPreloadTask r100, Continuation<? super InitBizPreloadTask$preloadActionBarImages$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return InitBizPreloadTask.a(this.this$0, null, this);
    }
}

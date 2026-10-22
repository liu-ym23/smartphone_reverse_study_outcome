package com.larus.bmhome.double_post.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo", f = "RecommendVideoApiRepo.kt", i = {1, 1}, l = {66, 69, 81}, m = "loadMoreData", n = {"requestType", "requestPage"}, s = {"L$0", "I$0"})
public final class RecommendVideoApiRepo$loadMoreData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApiRepo this$0;

    public RecommendVideoApiRepo$loadMoreData$1(RecommendVideoApiRepo r100, Continuation<? super RecommendVideoApiRepo$loadMoreData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, 0, null, null, null, null, this);
    }
}

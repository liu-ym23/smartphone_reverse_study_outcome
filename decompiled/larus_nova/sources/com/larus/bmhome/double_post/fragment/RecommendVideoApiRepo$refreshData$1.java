package com.larus.bmhome.double_post.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo", f = "RecommendVideoApiRepo.kt", i = {1}, l = {34, 37, 49}, m = "refreshData", n = {"requestType"}, s = {"L$0"})
public final class RecommendVideoApiRepo$refreshData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApiRepo this$0;

    public RecommendVideoApiRepo$refreshData$1(RecommendVideoApiRepo r100, Continuation<? super RecommendVideoApiRepo$refreshData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, null, null, null, null, this);
    }
}

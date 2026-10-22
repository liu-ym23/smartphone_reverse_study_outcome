package com.larus.bmhome.double_post.fragment;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo", f = "RecommendVideoApiRepo.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {148, 162}, m = "requestWithRetry", n = {"action", "retryTimes", "delayTime", MapMonitorConst.ATTEMPT, "action", "retryTimes", "delayTime"}, s = {"L$0", "I$0", "J$0", "I$2", "L$0", "I$0", "J$0"})
public final class RecommendVideoApiRepo$requestWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApiRepo this$0;

    public RecommendVideoApiRepo$requestWithRetry$1(RecommendVideoApiRepo r100, Continuation<? super RecommendVideoApiRepo$requestWithRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RecommendVideoApiRepo r101 = this.this$0;
        int r102 = RecommendVideoApiRepo.f311574b;
        return r101.e(0, 0, null, this);
    }
}

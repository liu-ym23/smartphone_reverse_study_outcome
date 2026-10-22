package com.larus.bmhome.chat.model.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.RealtimeFirstMetStrategy", f = "RealtimeFirstMetStrategy.kt", i = {}, l = {142}, m = "requireLocalOnBoardingMsg", n = {}, s = {})
final class RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeFirstMetStrategy this$0;

    public RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1(RealtimeFirstMetStrategy r100, Continuation<? super RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return RealtimeFirstMetStrategy.a(this.this$0, null, this);
    }
}

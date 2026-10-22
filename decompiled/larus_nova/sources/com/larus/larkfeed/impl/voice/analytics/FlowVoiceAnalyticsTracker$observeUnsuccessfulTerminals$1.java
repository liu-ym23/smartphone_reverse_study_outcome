package com.larus.larkfeed.impl.voice.analytics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.voice.analytics.FlowVoiceAnalyticsTracker", f = "FlowVoiceAnalyticsTracker.kt", i = {}, l = {90}, m = "observeUnsuccessfulTerminals", n = {}, s = {})
final class FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1(a r100, Continuation<? super FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return a.b(this.this$0, null, this);
    }
}

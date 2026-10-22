package com.larus.feedback.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector", f = "RecentFeedbackMessageCollector.kt", i = {}, l = {97}, m = "loadRecentConversations", n = {}, s = {})
public final class RecentFeedbackMessageCollector$loadRecentConversations$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentFeedbackMessageCollector this$0;

    public RecentFeedbackMessageCollector$loadRecentConversations$1(RecentFeedbackMessageCollector r100, Continuation<? super RecentFeedbackMessageCollector$loadRecentConversations$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RecentFeedbackMessageCollector r101 = this.this$0;
        RecentFeedbackMessageCollector r102 = RecentFeedbackMessageCollector.f343115a;
        return r101.b(this);
    }
}

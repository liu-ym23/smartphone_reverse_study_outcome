package com.larus.feedback.impl.service;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector", f = "RecentFeedbackMessageCollector.kt", i = {0, 0, 1, 1, 1}, l = {35, 42}, m = ShareChannel.COLLECT, n = {DyPayConstant.KEY_START_TIME, "recentMessageStartTime", "conversations", DyPayConstant.KEY_START_TIME, "recentMessageStartTime"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1"})
public final class RecentFeedbackMessageCollector$collect$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentFeedbackMessageCollector this$0;

    public RecentFeedbackMessageCollector$collect$1(RecentFeedbackMessageCollector r100, Continuation<? super RecentFeedbackMessageCollector$collect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}

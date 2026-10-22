package com.larus.livetutor.impl.tutor.data.feedback;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackConfig", f = "CommonFeedbackConfig.kt", i = {}, l = {27}, m = "requestFeedbackConfig", n = {}, s = {})
public final class CommonFeedbackConfig$requestFeedbackConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonFeedbackConfig this$0;

    public CommonFeedbackConfig$requestFeedbackConfig$1(CommonFeedbackConfig r100, Continuation<? super CommonFeedbackConfig$requestFeedbackConfig$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, this);
    }
}

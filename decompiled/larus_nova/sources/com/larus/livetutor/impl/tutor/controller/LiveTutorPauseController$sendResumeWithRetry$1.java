package com.larus.livetutor.impl.tutor.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.tutor.controller.LiveTutorPauseController", f = "LiveTutorPauseController.kt", i = {0, 0, 0, 0}, l = {144}, m = "sendResumeWithRetry", n = {"pauseReason", "$this$sendResumeWithRetry_u24lambda_u2410_u24lambda_u248", "maxRetries", "retryTime"}, s = {"L$0", "L$1", "I$0", "I$2"})
public final class LiveTutorPauseController$sendResumeWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveTutorPauseController this$0;

    public LiveTutorPauseController$sendResumeWithRetry$1(LiveTutorPauseController r100, Continuation<? super LiveTutorPauseController$sendResumeWithRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveTutorPauseController r101 = this.this$0;
        int r102 = LiveTutorPauseController.f356447f;
        return r101.f(null, 0, this);
    }
}

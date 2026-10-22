package com.larus.office.base.watermark.poller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.poller.AsyncTaskPoller", f = "AsyncTaskPoller.kt", i = {}, l = {21}, m = "poll", n = {}, s = {})
public final class AsyncTaskPoller$poll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncTaskPoller this$0;

    public AsyncTaskPoller$poll$1(AsyncTaskPoller r100, Continuation<? super AsyncTaskPoller$poll$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}

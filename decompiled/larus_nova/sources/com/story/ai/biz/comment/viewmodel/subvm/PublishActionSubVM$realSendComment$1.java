package com.story.ai.biz.comment.viewmodel.subvm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.story.ai.biz.comment.viewmodel.subvm.PublishActionSubVM", f = "PublishActionSubVM.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {66, 95}, m = "realSendComment", n = {"publishData", "isRetry", "position", "publishData", "code", "isRetry", "position"}, s = {"L$0", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0"})
public final class PublishActionSubVM$realSendComment$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublishActionSubVM this$0;

    public PublishActionSubVM$realSendComment$1(PublishActionSubVM r100, Continuation<? super PublishActionSubVM$realSendComment$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, 0, this);
    }
}

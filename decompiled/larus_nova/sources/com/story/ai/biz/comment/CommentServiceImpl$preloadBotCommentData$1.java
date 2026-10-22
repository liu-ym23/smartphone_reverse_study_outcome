package com.story.ai.biz.comment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.story.ai.biz.comment.CommentServiceImpl", f = "CommentServiceImpl.kt", i = {}, l = {105}, m = "preloadBotCommentData", n = {}, s = {})
final class CommentServiceImpl$preloadBotCommentData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommentServiceImpl this$0;

    public CommentServiceImpl$preloadBotCommentData$1(CommentServiceImpl r100, Continuation<? super CommentServiceImpl$preloadBotCommentData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}

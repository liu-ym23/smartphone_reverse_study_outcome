package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$CommentHandler", f = "AsideComment.kt", i = {}, l = {491, 493}, m = "awaitScrollIdle", n = {}, s = {})
final class AsideComment$CommentHandler$awaitScrollIdle$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsideComment.a this$0;

    public AsideComment$CommentHandler$awaitScrollIdle$1(AsideComment.a r1, Continuation<? super AsideComment$CommentHandler$awaitScrollIdle$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AsideComment.a.a(this.this$0, this);
    }
}

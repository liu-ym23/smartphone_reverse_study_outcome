package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class Comment$inputCommentFunction$1 {
    public Function1<? super CommentInputRequest, Unit> a;
    public Function1<? super CommentInputRequest, Unit> b;
    public final Function0<Unit> c;
    public final Function0<Boolean> d;
    public final Function0<CommentInputRequest> e;
    public final /* synthetic */ Comment f;

    public Comment$inputCommentFunction$1(final Comment r2) {
        this.f = r2;
        this.a = new Comment$inputCommentFunction$1$clickEditInNewCard$1(r2);
        this.b = new Comment$inputCommentFunction$1$clickReplyInReaction$1(r2);
        this.c = new Comment$inputCommentFunction$1$closeInputComment$1(r2);
        this.d = new Comment$inputCommentFunction$1$isShowingInputComment$1(r2);
        this.e = new Comment$inputCommentFunction$1$getInputCommentInputRequest$1(r2);
    }

    public final void a(CommentInputRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "inputRequest");
        p1 r0 = this.f.o;
        if (r0 == null) goto L6;
        r0.tI(r2.comment_id);
        return;
    }
}

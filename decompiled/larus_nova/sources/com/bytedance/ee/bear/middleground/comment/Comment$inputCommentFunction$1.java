package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class Comment$inputCommentFunction$1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super CommentInputRequest, Unit> f230083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super CommentInputRequest, Unit> f230084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f230085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f230086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<CommentInputRequest> f230087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Comment f230088f;

    public Comment$inputCommentFunction$1(final Comment r100) {
        this.f230088f = r100;
        this.f230083a = new Comment$inputCommentFunction$1$clickEditInNewCard$1(r100);
        this.f230084b = new Comment$inputCommentFunction$1$clickReplyInReaction$1(r100);
        this.f230085c = new Comment$inputCommentFunction$1$closeInputComment$1(r100);
        this.f230086d = new Comment$inputCommentFunction$1$isShowingInputComment$1(r100);
        this.f230087e = new Comment$inputCommentFunction$1$getInputCommentInputRequest$1(r100);
    }

    public final void a(CommentInputRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "inputRequest");
        p1 r101 = this.f230088f.f230042o;
        if (r101 == null) goto L6;
        r101.tI(r100.comment_id);
        return;
    }
}

package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.uitls.p f230951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.control.z f230952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf5.a f230953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f230954d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Fa(CardCommentHeight r100) {
        Intrinsics.checkNotNullParameter(r100, "height");
    }

    public boolean a() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void h5(Function0 r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void jN() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void t2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void tI(String r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void v2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ boolean wB() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Hg() {
        this.f230953c.d();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v4() {
        this.f230953c.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public void Ni(boolean r100) {
        tt5.a.h("Comment#CardComment2Wrapper", "dismiss()... , shouldShowAnimator = " + r100);
        sa5.b r101 = this.f230952b.s1();
        if (r101 == null) goto L5;
        r101.d(this.f230954d);
    L5:
        this.f230953c.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public void fj(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        tt5.a.h("Comment#CardComment2Wrapper", "show()... cardComment2Impl = " + this.f230951a.f232238n + ", targetId = " + r100 + ", height = " + r101);
        sa5.b r102 = this.f230952b.s1();
        if (r102 == null) goto L6;
        r102.e(this.f230954d);
        return;
    }

    public b(com.bytedance.ee.bear.middleground.comment.uitls.p r100, Comment r101, com.bytedance.ee.bear.middleground.comment.control.t r102, com.bytedance.ee.bear.middleground.comment.control.y r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "commentListeners");
        Intrinsics.checkNotNullParameter(r102, "dataControl");
        Intrinsics.checkNotNullParameter(r103, "actionControl");
        this.f230951a = r100;
        this.f230952b = r101;
        this.f230953c = new jf5.a(r100, r101);
        this.f230954d = new c(this);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void i8(String r100, String r110, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r111, int r112, CommentBean r113, CommentImageShowSource r114) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r110, "replyId");
        Intrinsics.checkNotNullParameter(r114, "showSource");
        jf5.a r101 = this.f230953c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r110, "replyId");
        Intrinsics.checkNotNullParameter(r114, "showSource");
        r101.c(r100, r110, r111, r112, false, r113, r114);
    }
}

package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b implements p1 {
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final com.bytedance.ee.bear.middleground.comment.control.z b;
    public final jf5.a c;
    public final c d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Fa(CardCommentHeight r2) {
        Intrinsics.checkNotNullParameter(r2, "height");
    }

    public boolean a() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void h5(Function0 r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void jN() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void t2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public /* synthetic */ void tI(String r1) {
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
        this.c.d();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v4() {
        this.c.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public void Ni(boolean r3) {
        tt5.a.h("Comment#CardComment2Wrapper", "dismiss()... , shouldShowAnimator = " + r3);
        sa5.b r4 = this.b.s1();
        if (r4 == null) goto L5;
        r4.d(this.d);
    L5:
        this.c.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public void fj(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        tt5.a.h("Comment#CardComment2Wrapper", "show()... cardComment2Impl = " + this.a.n + ", targetId = " + r3 + ", height = " + r4);
        sa5.b r5 = this.b.s1();
        if (r5 == null) goto L6;
        r5.e(this.d);
        return;
    }

    public b(com.bytedance.ee.bear.middleground.comment.uitls.p r2, Comment r3, com.bytedance.ee.bear.middleground.comment.control.t r4, com.bytedance.ee.bear.middleground.comment.control.y r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        this.a = r2;
        this.b = r3;
        this.c = new jf5.a(r2, r3);
        this.d = new c(this);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void i8(String r9, String r10, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, int r12, CommentBean r13, CommentImageShowSource r14) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "showSource");
        jf5.a r5 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "showSource");
        r5.c(r9, r10, r11, r12, false, r13, r14);
    }
}

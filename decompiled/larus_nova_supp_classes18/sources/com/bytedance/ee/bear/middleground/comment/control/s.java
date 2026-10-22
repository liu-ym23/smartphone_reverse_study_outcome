package com.bytedance.ee.bear.middleground.comment.control;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements a0 {
    public a0 a;

    public static final class a {
    }

    static {
    }

    public s() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userName");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void g(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void r(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.r(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void m(String r2, VisibilityBean r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "visibility");
        Intrinsics.checkNotNullParameter(r4, "forwardId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.m(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void o(String r2, String r3, SmartReplyDataForInsert r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.o(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void p(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.p(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void s(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.s(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void A(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.A(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void j(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        a0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.j(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void k(String r8, String r9, int r10, int r11, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r12, "imageList");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.k(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void l(String r8, String r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r11, "reactionKey");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.l(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void u(String r8, String r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r11, "reactionKey");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.u(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void n(String r10, int r11, VisibilityBean r12, String r13, boolean r14, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r12, "visibility");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.n(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void q(String r10, String r11, String r12, int r13, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "commentId");
        Intrinsics.checkNotNullParameter(r11, "replyId");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.q(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void e(String r11, String r12, int r13, String r14, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r15, String r16, boolean r17, SmartReplyDataForInsert r18) {
        Intrinsics.checkNotNullParameter(r11, "commentId");
        a0 r1 = this.a;
        if (r1 == null) goto L6;
        r1.e(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    }
}

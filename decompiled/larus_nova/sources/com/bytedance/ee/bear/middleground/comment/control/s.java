package com.bytedance.ee.bear.middleground.comment.control;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f231244a;

    public static final class a {
    }

    static {
    }

    public s() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        a0 r101 = this.f231244a;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        a0 r101 = this.f231244a;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "replyId");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void r(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.r(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void a(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "replyId");
        a0 r103 = this.f231244a;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void m(String r100, VisibilityBean r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.Notification.VISIBILITY);
        Intrinsics.checkNotNullParameter(r102, "forwardId");
        a0 r103 = this.f231244a;
        if (r103 == null) goto L6;
        r103.m(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void o(String r100, String r101, SmartReplyDataForInsert r102) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        a0 r103 = this.f231244a;
        if (r103 == null) goto L6;
        r103.o(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void p(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "replyId");
        a0 r103 = this.f231244a;
        if (r103 == null) goto L6;
        r103.p(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void s(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "replyId");
        a0 r103 = this.f231244a;
        if (r103 == null) goto L6;
        r103.s(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void A(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "referKey");
        Intrinsics.checkNotNullParameter(r103, "reactionKey");
        a0 r104 = this.f231244a;
        if (r104 == null) goto L6;
        r104.A(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void j(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "referKey");
        Intrinsics.checkNotNullParameter(r103, "reactionKey");
        a0 r104 = this.f231244a;
        if (r104 == null) goto L6;
        r104.j(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void k(String r100, String r101, int r110, int r111, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r112) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        Intrinsics.checkNotNullParameter(r112, "imageList");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.k(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void l(String r100, String r101, int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        Intrinsics.checkNotNullParameter(r111, "reactionKey");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.l(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void u(String r100, String r101, int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        Intrinsics.checkNotNullParameter(r111, "reactionKey");
        a0 r102 = this.f231244a;
        if (r102 == null) goto L6;
        r102.u(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void n(String r110, int r111, VisibilityBean r112, String r113, boolean r114, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.Notification.VISIBILITY);
        a0 r100 = this.f231244a;
        if (r100 == null) goto L6;
        r100.n(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void q(String r110, String r111, String r112, int r113, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r114, boolean r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "commentId");
        Intrinsics.checkNotNullParameter(r111, "replyId");
        a0 r100 = this.f231244a;
        if (r100 == null) goto L6;
        r100.q(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void e(String r110, String r111, int r112, String r113, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r114, String r115, boolean r116, SmartReplyDataForInsert r117) {
        Intrinsics.checkNotNullParameter(r110, "commentId");
        a0 r100 = this.f231244a;
        if (r100 == null) goto L6;
        r100.e(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }
}

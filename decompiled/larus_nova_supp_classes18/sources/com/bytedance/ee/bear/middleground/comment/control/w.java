package com.bytedance.ee.bear.middleground.comment.control;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements t {
    public final a0 a;
    public final com.bytedance.ee.bear.rn.k b;
    public final MutableLiveData<List<CommentBean>> c;
    public final MutableLiveData<List<CommentBean>> d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void P() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void Q(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void m(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "translateLang");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "newToken");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void q(f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "dataObserver");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void s(sbb.e r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void v(CommentMetadata[] r2) {
        Intrinsics.checkNotNullParameter(r2, "comments");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final void w(String r2, Action r3) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r3, "action");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void x(String r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void K() {
        this.b.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> getComment() {
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final MutableLiveData<List<CommentBean>> I() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> B(com.bytedance.ee.bear.rn.e r12) {
        Intrinsics.checkNotNullParameter(r12, "publishCommentParams");
        a0 r1 = this.a;
        String r0 = r12.c;
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        r1.e(r2, r12.b, r12.q, r12.g, r12.f, r12.o, r12.k, r12.r);
        return Flowable.just("");
    L5:
        r2 = r0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> C(com.bytedance.ee.bear.rn.e r5) {
        Intrinsics.checkNotNullParameter(r5, "publishCommentParams");
        a0 r0 = this.a;
        String r1 = r5.c;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r3 = r5.q;
        String r6 = r5.j;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.p(r1, r3, r6);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> D(com.bytedance.ee.bear.rn.a r5) {
        Intrinsics.checkNotNullParameter(r5, "clearInputTextParams");
        a0 r0 = this.a;
        String r1 = r5.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.o(r1, r5.b, r5.c);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> G(com.bytedance.ee.bear.rn.d r11) {
        Intrinsics.checkNotNullParameter(r11, "editCommentParams");
        a0 r1 = this.a;
        String r0 = r11.a;
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r3 = r11.b;
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        r1.q(r2, r4, r11.c, r11.j, r11.d, r11.h, r11.k);
        return Flowable.just("");
    L9:
        r4 = r3;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void J(List<CommentBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        tt5.a.h("Comment#DataControlWebImpl", "updateResolvedList size = " + r3.size());
        this.d.setValue(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void L(List<CommentBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        tt5.a.h("Comment#DataControlWebImpl", "updateList size = " + r3.size());
        this.c.setValue(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> M(com.bytedance.ee.bear.rn.e r5) {
        Intrinsics.checkNotNullParameter(r5, "publishCommentParams");
        a0 r0 = this.a;
        String r1 = r5.c;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r3 = r5.q;
        String r6 = r5.j;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.p(r1, r3, r6);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final CommentBean N(String r5) {
        Object r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        List r0 = (List) this.c.getValue();
        if (r0 == null) goto L18;
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (TextUtils.equals(r5, ((CommentBean) r3).getComment_id()) == false) goto L9;
        r1 = r3;
    L14:
        return (CommentBean) r1;
    L18:
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final CommentBean O(String r5) {
        Object r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        List r0 = (List) this.d.getValue();
        if (r0 == null) goto L18;
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (TextUtils.equals(r5, ((CommentBean) r3).getComment_id()) == false) goto L9;
        r1 = r3;
    L14:
        return (CommentBean) r1;
    L18:
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.a.d(r2);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.a.f(r2);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> g(com.bytedance.ee.bear.rn.e r10) {
        Intrinsics.checkNotNullParameter(r10, "publishCommentParams");
        this.a.n(r10.b, r10.q, r10.p, r10.g, r10.e, r10.f, r10.k);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> p(com.bytedance.ee.bear.rn.d r5) {
        Intrinsics.checkNotNullParameter(r5, "editCommentParams");
        a0 r0 = this.a;
        String r1 = r5.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r3 = r5.j;
        String r6 = r5.b;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.p(r1, r3, r6);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> z(com.bytedance.ee.bear.rn.e r5) {
        Intrinsics.checkNotNullParameter(r5, "publishCommentParams");
        a0 r0 = this.a;
        String r1 = r5.c;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r3 = r5.q;
        String r6 = r5.j;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.p(r1, r3, r6);
        return Flowable.just("");
    }

    public w(s r2, com.bytedance.ee.bear.rn.k r3) {
        Intrinsics.checkNotNullParameter(r2, "commentWebSdk");
        Intrinsics.checkNotNullParameter(r3, "reactionSDK");
        this.a = r2;
        this.b = r3;
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final boolean b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userName");
        this.a.b(r2, r3);
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        this.a.c(r2, r3);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        this.a.h(r2, r3);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        this.a.i(r2, r3);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable r(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.a.r(r2, r3);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void y(Comment.g r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dataObserver");
        this.b.y(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> E(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        this.a.p(r2, r3, r4);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> F(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "referType");
        Intrinsics.checkNotNullParameter(r3, "referKey");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> H(String r2, VisibilityBean r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "visibility");
        Intrinsics.checkNotNullParameter(r4, "forwardId");
        this.a.m(r2, r3, r4);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable R(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        this.a.s(r2, r3, r4);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        this.a.a(r2, r3, r4);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> n(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        this.a.p(r2, r3, r4);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> t(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "referType");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        this.a.g(r4, r3);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> A(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        this.a.A(r2, r3, r4, r5);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> j(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        this.a.j(r2, r3, r4, r5);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> k(String r8, String r9, int r10, int r11, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r12, "imageList");
        this.a.k(r8, r9, r10, r11, r12);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> l(String r8, String r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r11, "reactionKey");
        this.a.l(r8, r9, r10, r11, r12);
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> u(String r8, String r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Intrinsics.checkNotNullParameter(r11, "reactionKey");
        this.a.u(r8, r9, r10, r11, r12);
        return Flowable.just("{\"data\":{\"body\":{\"code\":0}}}");
    }
}

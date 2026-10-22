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
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements t {
    public final com.bytedance.ee.bear.rn.g a;
    public final com.bytedance.ee.bear.rn.k b;
    public final Function2<String, Action, Unit> c;
    public final MutableLiveData<List<CommentBean>> d;
    public final MutableLiveData<List<CommentBean>> e;
    public com.bytedance.ee.bear.rn.e f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final boolean b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userName");
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void K() {
        this.b.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void P() {
        this.a.k();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> getComment() {
        Flowable<String> r0 = this.a.n();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final MutableLiveData<List<CommentBean>> I() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> B(com.bytedance.ee.bear.rn.e r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCommentParams");
        Flowable<String> r3 = this.a.B(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> C(com.bytedance.ee.bear.rn.e r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCommentParams");
        return g(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> D(com.bytedance.ee.bear.rn.a r2) {
        Intrinsics.checkNotNullParameter(r2, "clearInputTextParams");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> G(com.bytedance.ee.bear.rn.d r2) {
        Intrinsics.checkNotNullParameter(r2, "editCommentParams");
        Flowable<String> r3 = this.a.j(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void J(List<CommentBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        tt5.a.h("Comment#DataControlRNImpl", "updateResolvedList size = " + r3.size());
        this.e.setValue(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void L(List<CommentBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        tt5.a.h("Comment#DataControlRNImpl", "updateList size = " + r3.size());
        this.d.setValue(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> M(com.bytedance.ee.bear.rn.e r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCommentParams");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final CommentBean N(String r5) {
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
    public final CommentBean O(String r5) {
        Object r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        List r0 = (List) this.e.getValue();
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
    public final void Q(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return this.a.e(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> g(com.bytedance.ee.bear.rn.e r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCommentParams");
        if (r2.l == null) goto L5;
        this.f = r2;
    L5:
        Flowable<String> r3 = this.a.g(r2);
        if (r3 == null) goto L8;
        return r3;
    L8:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "newToken");
        this.a.c(r2);
        this.b.c(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> p(com.bytedance.ee.bear.rn.d r2) {
        Intrinsics.checkNotNullParameter(r2, "editCommentParams");
        return G(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void q(f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "dataObserver");
        this.a.q(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void s(sbb.e r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
        this.a.b(r2);
        this.b.b(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void v(CommentMetadata[] r2) {
        Intrinsics.checkNotNullParameter(r2, "comments");
        this.a.v(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void x(String r2) {
        this.a.x(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> z(com.bytedance.ee.bear.rn.e r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCommentParams");
        return B(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final void m(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "translateLang");
        this.a.m(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable r(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Flowable<String> r3 = this.a.d(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final void w(String r2, Action r3) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r3, "action");
        this.c.invoke(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final void y(Comment.g r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.y(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(com.bytedance.ee.bear.rn.g r2, com.bytedance.ee.bear.rn.k r3, Function2<? super String, ? super Action, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "commentSDK");
        Intrinsics.checkNotNullParameter(r3, "reactionSDK");
        Intrinsics.checkNotNullParameter(r4, "filter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    @Deprecated(message = "rn兼容 新建评论显示toast功能")
    public final Flowable<String> E(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        com.bytedance.ee.bear.rn.e r5 = this.f;
        if (r5 != null) goto L7;
        return Flowable.error(new NullPointerException(" commentId " + r2 + " not exist"));
    L7:
        return g(r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> F(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "referType");
        Intrinsics.checkNotNullParameter(r4, "referKey");
        Flowable<String> r5 = this.b.e(r3, r4, r2);
        if (r5 == null) goto L5;
        return r5;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> H(String r1, VisibilityBean r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        Intrinsics.checkNotNullParameter(r3, "forwardId");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable R(String r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        Flowable<String> r4 = this.a.l(r1, r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> a(String r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        Flowable<String> r4 = this.a.i(r1, r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> n(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        return R(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t, com.bytedance.ee.bear.middleground.comment.export.p
    public final Flowable<String> t(String r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "referType");
        Intrinsics.checkNotNullParameter(r3, "referKey");
        Flowable<String> r4 = this.b.g(r1, r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> A(String r1, int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r3, "referKey");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> j(String r1, int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r3, "referKey");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        return Flowable.error(new Throwable("RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> k(String r1, String r2, int r3, int r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r2, "replyId");
        Intrinsics.checkNotNullParameter(r5, "imageList");
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> l(String r1, String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r2, "replyId");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        Flowable<String> r6 = this.b.f(r2, r4);
        if (r6 == null) goto L5;
        return r6;
    L5:
        return Flowable.error(new Throwable("removeReaction RN SDK get data error"));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.t
    public final Flowable<String> u(String r1, String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r2, "replyId");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        Flowable<String> r6 = this.b.d(r2, r4);
        if (r6 == null) goto L5;
        return r6;
    L5:
        return Flowable.error(new Throwable("addReaction RN SDK get data error"));
    }
}

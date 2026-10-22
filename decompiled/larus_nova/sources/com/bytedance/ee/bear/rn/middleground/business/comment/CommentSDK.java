package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.middleground.comment.control.v;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.d;
import com.bytedance.ee.bear.rn.g;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import uf5.p0;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentSDK implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f236581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f236582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f236583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f236584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.rn.middleground.business.comment.a f236585e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void a() {
        tt5.a.h("CommentSDK", "unregisterCommentDataObserver");
        s(null);
        b r100 = this.f236583c;
        this.f236583c = null;
        if (r100 == null) goto L6;
        RnSyncManager r101 = RnSyncManager.f236496a;
        RnSyncManager.q(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void k() {
        tt5.a.h("CommentSDK", "unregisterAuthorizeObserver");
        com.bytedance.ee.bear.rn.middleground.business.comment.a r100 = this.f236585e;
        if (r100 == null) goto L6;
        this.f236585e = null;
        RnSyncManager r101 = RnSyncManager.f236496a;
        RnSyncManager.q(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void p() {
        tt5.a.h("CommentSDK", "unregisterMessageObserver");
        c r100 = this.f236584d;
        this.f236584d = null;
        if (r100 == null) goto L6;
        RnSyncManager r101 = RnSyncManager.f236496a;
        RnSyncManager.q(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> n() {
        String r100 = yl5.b.a();
        return w(u(this, new CommentProtocol.Fetch(), r100, null, false, CommentSDK$fetchComment$jsonString$1.INSTANCE, 12), r100);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> B(final com.bytedance.ee.bear.rn.e r100) {
        Intrinsics.checkNotNullParameter(r100, "publishCommentParams");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Publish(), r101, null, false, new CommentSDK$replyComment$jsonString$1(r100, this), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "documentType");
        this.f236582b = r100;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        this.f236581a = r100;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Update(), r101, null, false, new CommentSDK$resolveComment$jsonString$1(r100), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> e(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Query(), r101, null, false, new CommentSDK$queryComment$jsonString$1(r100), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void f(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c r101 = new c(this, r100);
        this.f236584d = r101;
        RnSyncManager r102 = RnSyncManager.f236496a;
        RnSyncManager.h(r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> g(final com.bytedance.ee.bear.rn.e r100) {
        Intrinsics.checkNotNullParameter(r100, "publishCommentParams");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Publish(), r101, null, false, new CommentSDK$createComment$jsonString$1(r100, this), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> j(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "editCommentParams");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Edit(), r101, null, false, new CommentSDK$modifyComment$jsonString$1(r100, this), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void o(v r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        b r101 = new b(this, r100);
        this.f236583c = r101;
        RnSyncManager r102 = RnSyncManager.f236496a;
        RnSyncManager.h(r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void q(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("CommentSDK", "registerAuthorizeObserver");
        com.bytedance.ee.bear.rn.middleground.business.comment.a r101 = new com.bytedance.ee.bear.rn.middleground.business.comment.a(this, r100);
        this.f236585e = r101;
        RnSyncManager r102 = RnSyncManager.f236496a;
        RnSyncManager.h(r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> r(boolean r100) {
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.FetchNoticeList(), r101, null, r100, CommentSDK$fetchNoticeList$jsonString$1.INSTANCE, 4), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void s(String r100) {
        Flowable r101 = w(u(this, new CommentProtocol.EndSync(), null, r100, false, CommentSDK$endSyncComment$jsonString$1.INSTANCE, 10), null);
        if (r101 == null) goto L5;
        r101.subscribe();
    L5:
        tt5.a.h("CommentSDK", CommentJsRequestBean.ACTION_END_SYNC);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void v(final CommentMetadata[] r110) {
        Intrinsics.checkNotNullParameter(r110, "comments");
        tt5.a.h("CommentSDK", CommentJsRequestBean.ACTION_ADD_TRANSLATE_COMMENTS);
        Flowable r111 = w(u(this, new CommentProtocol.AddTranslateComments(), null, null, false, new CommentSDK$addTranslateComments$jsonString$1(r110), 14), null);
        if (r111 == null) goto L6;
        r111.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void x(String r100) {
        Flowable r101 = w(u(this, new CommentProtocol.BeginSync(), null, r100, false, new CommentSDK$beginSyncComment$jsonString$1(this), 10), null);
        if (r101 == null) goto L5;
        r101.subscribe();
    L5:
        tt5.a.h("CommentSDK", CommentJsRequestBean.ACTION_BEGIN_SNYC);
    }

    public CommentSDK(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r101, "documentType");
        this.f236581a = r100;
        this.f236582b = r101;
    }

    public static final CommentProtocol.Body.Extra t(CommentSDK r100, List r101) {
        r100.getClass();
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L7;
        boolean r103 = true;
        if ((!r101.isEmpty()) != true) goto L7;
    L8:
        if (r103 == false) goto L14;
        Iterator r104 = r101.iterator();
    L11:
        if (r104.hasNext() == false) goto L14;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r105 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r104.next();
        r102.add(new CommentProtocol.Body.Extra.CommentImageItem(r105.getToken(), r105.getUuid(), r105.getSrc(), r105.getOriginalSrc()));
    L14:
        return new CommentProtocol.Body.Extra(null, null, r102);
    L7:
        r103 = false;
        goto L8
    }

    public static Flowable w(final String r100, final String r101) {
        return yl5.b.b(new CommentSDK$sendMessage$1(r101, r100));
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> h(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "options");
        String r111 = yl5.b.a();
        return w(u(this, new CommentProtocol.FetchMessage(), r111, null, r100, CommentSDK$fetchMessage$jsonString$1.INSTANCE, 4), r111);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> i(final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r110, "commentId");
        Intrinsics.checkNotNullParameter(r111, "replyId");
        tt5.a.h("CommentSDK", "translate");
        String r100 = yl5.b.a();
        return w(u(this, new CommentProtocol.Translate(), r100, null, false, new CommentSDK$translate$jsonString$1(r110, r111), 12), r100);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> l(final String r100, final String r110) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r110, "replyId");
        String r101 = yl5.b.a();
        return w(u(this, new CommentProtocol.Delete(), r101, null, false, new CommentSDK$deleteComment$jsonString$1(r100, r110), 12), r101);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void m(final String r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "translateLang");
        tt5.a.h("CommentSDK", "setTranslateEnableLang, translateLang: " + r110 + ", isAutoTranslate: " + r111);
        Flowable r112 = w(u(this, new CommentProtocol.SetTranslateEnableLang(), null, null, false, new CommentSDK$setTranslateEnableLang$jsonString$1(r110, r111), 14), null);
        if (r112 == null) goto L6;
        r112.subscribe();
        return;
    }

    public static String u(CommentSDK r100, Protocol r101, String r102, String r103, boolean r104, Function1 r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 8) == 0) goto L11;
        r104 = false;
    L11:
        if (r102 == null) goto L13;
        r100.getClass();
        r101.setHeader(new Protocol.Entity.Header(r102));
    L13:
        int r107 = r100.f236582b.f541317b;
        if (r103 != null) goto L16;
        r103 = r100.f236581a;
    L16:
        r101.setIdentifier(new Protocol.Entity.Identifier(r107, r103, r104, null));
        r105.invoke(r101);
        return r101.getJsonString();
    }
}

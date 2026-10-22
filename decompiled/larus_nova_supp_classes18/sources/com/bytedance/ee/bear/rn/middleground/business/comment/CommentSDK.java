package com.bytedance.ee.bear.rn.middleground.business.comment;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentSDK implements g {
    public String a;
    public e b;
    public b c;
    public c d;
    public com.bytedance.ee.bear.rn.middleground.business.comment.a e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void a() {
        tt5.a.h("CommentSDK", "unregisterCommentDataObserver");
        s(null);
        b r1 = this.c;
        this.c = null;
        if (r1 == null) goto L6;
        RnSyncManager r0 = RnSyncManager.a;
        RnSyncManager.q(r1);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void k() {
        tt5.a.h("CommentSDK", "unregisterAuthorizeObserver");
        com.bytedance.ee.bear.rn.middleground.business.comment.a r0 = this.e;
        if (r0 == null) goto L6;
        this.e = null;
        RnSyncManager r1 = RnSyncManager.a;
        RnSyncManager.q(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void p() {
        tt5.a.h("CommentSDK", "unregisterMessageObserver");
        c r0 = this.d;
        this.d = null;
        if (r0 == null) goto L6;
        RnSyncManager r1 = RnSyncManager.a;
        RnSyncManager.q(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> n() {
        String r7 = yl5.b.a();
        return w(u(this, new CommentProtocol.Fetch(), r7, null, false, CommentSDK$fetchComment$jsonString$1.INSTANCE, 12), r7);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> B(final com.bytedance.ee.bear.rn.e r9) {
        Intrinsics.checkNotNullParameter(r9, "publishCommentParams");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Publish(), r0, null, false, new CommentSDK$replyComment$jsonString$1(r9, this), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void b(e r2) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> d(final String r9) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Update(), r0, null, false, new CommentSDK$resolveComment$jsonString$1(r9), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> e(final String r9) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Query(), r0, null, false, new CommentSDK$queryComment$jsonString$1(r9), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void f(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        c r0 = new c(this, r2);
        this.d = r0;
        RnSyncManager r3 = RnSyncManager.a;
        RnSyncManager.h(r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> g(final com.bytedance.ee.bear.rn.e r9) {
        Intrinsics.checkNotNullParameter(r9, "publishCommentParams");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Publish(), r0, null, false, new CommentSDK$createComment$jsonString$1(r9, this), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> j(final d r9) {
        Intrinsics.checkNotNullParameter(r9, "editCommentParams");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Edit(), r0, null, false, new CommentSDK$modifyComment$jsonString$1(r9, this), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void o(v r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        b r0 = new b(this, r2);
        this.c = r0;
        RnSyncManager r3 = RnSyncManager.a;
        RnSyncManager.h(r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void q(f1 r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        tt5.a.h("CommentSDK", "registerAuthorizeObserver");
        com.bytedance.ee.bear.rn.middleground.business.comment.a r0 = new com.bytedance.ee.bear.rn.middleground.business.comment.a(this, r3);
        this.e = r0;
        RnSyncManager r4 = RnSyncManager.a;
        RnSyncManager.h(r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> r(boolean r9) {
        String r7 = yl5.b.a();
        return w(u(this, new CommentProtocol.FetchNoticeList(), r7, null, r9, CommentSDK$fetchNoticeList$jsonString$1.INSTANCE, 4), r7);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void s(String r8) {
        Flowable r9 = w(u(this, new CommentProtocol.EndSync(), null, r8, false, CommentSDK$endSyncComment$jsonString$1.INSTANCE, 10), null);
        if (r9 == null) goto L5;
        r9.subscribe();
    L5:
        tt5.a.h("CommentSDK", "endSync");
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void v(final CommentMetadata[] r10) {
        Intrinsics.checkNotNullParameter(r10, "comments");
        tt5.a.h("CommentSDK", "addTranslateComments");
        Flowable r11 = w(u(this, new CommentProtocol.AddTranslateComments(), null, null, false, new CommentSDK$addTranslateComments$jsonString$1(r10), 14), null);
        if (r11 == null) goto L6;
        r11.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void x(String r8) {
        Flowable r9 = w(u(this, new CommentProtocol.BeginSync(), null, r8, false, new CommentSDK$beginSyncComment$jsonString$1(this), 10), null);
        if (r9 == null) goto L5;
        r9.subscribe();
    L5:
        tt5.a.h("CommentSDK", "beginSync");
    }

    public CommentSDK(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        Intrinsics.checkNotNullParameter(r3, "documentType");
        this.a = r2;
        this.b = r3;
    }

    public static final CommentProtocol.Body.Extra t(CommentSDK r5, List r6) {
        r5.getClass();
        ArrayList r7 = new ArrayList();
        if (r6 == null) goto L7;
        boolean r1 = true;
        if ((!r6.isEmpty()) != true) goto L7;
    L8:
        if (r1 == false) goto L14;
        Iterator r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L14;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r0 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r8.next();
        r7.add(new CommentProtocol.Body.Extra.CommentImageItem(r0.getToken(), r0.getUuid(), r0.getSrc(), r0.getOriginalSrc()));
    L14:
        return new CommentProtocol.Body.Extra(null, null, r7);
    L7:
        r1 = false;
        goto L8
    }

    public static Flowable w(final String r1, final String r2) {
        return yl5.b.b(new CommentSDK$sendMessage$1(r2, r1));
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> h(boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "options");
        String r11 = yl5.b.a();
        return w(u(this, new CommentProtocol.FetchMessage(), r11, null, r9, CommentSDK$fetchMessage$jsonString$1.INSTANCE, 4), r11);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> i(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "commentId");
        Intrinsics.checkNotNullParameter(r11, "replyId");
        tt5.a.h("CommentSDK", "translate");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Translate(), r0, null, false, new CommentSDK$translate$jsonString$1(r10, r11), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final Flowable<String> l(final String r9, final String r10) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        String r0 = yl5.b.a();
        return w(u(this, new CommentProtocol.Delete(), r0, null, false, new CommentSDK$deleteComment$jsonString$1(r9, r10), 12), r0);
    }

    @Override // com.bytedance.ee.bear.rn.g
    public final void m(final String r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "translateLang");
        tt5.a.h("CommentSDK", "setTranslateEnableLang, translateLang: " + r10 + ", isAutoTranslate: " + r11);
        Flowable r12 = w(u(this, new CommentProtocol.SetTranslateEnableLang(), null, null, false, new CommentSDK$setTranslateEnableLang$jsonString$1(r10, r11), 14), null);
        if (r12 == null) goto L6;
        r12.subscribe();
        return;
    }

    public static String u(CommentSDK r2, Protocol r3, String r4, String r5, boolean r6, Function1 r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L11;
        r6 = false;
    L11:
        if (r4 == null) goto L13;
        r2.getClass();
        r3.setHeader(new Protocol.Entity.Header(r4));
    L13:
        int r9 = r2.b.b;
        if (r5 != null) goto L16;
        r5 = r2.a;
    L16:
        r3.setIdentifier(new Protocol.Entity.Identifier(r9, r5, r6, null));
        r7.invoke(r3);
        return r3.getJsonString();
    }
}

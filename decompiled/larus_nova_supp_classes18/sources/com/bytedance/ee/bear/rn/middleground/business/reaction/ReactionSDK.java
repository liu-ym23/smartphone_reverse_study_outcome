package com.bytedance.ee.bear.rn.middleground.business.reaction;

import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.k;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import yl5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ReactionSDK implements k {
    public String a;
    public e b;
    public final yl5.a c;
    public com.bytedance.ee.bear.rn.middleground.business.reaction.a d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final void a() {
        if (this.c.a() != 0) goto L7;
        ReactionProtocol.EndSync r0 = new ReactionProtocol.EndSync();
        r0.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        final String r1 = r0.getJsonString();
        Flowable<String> r2 = b.b(new ReactionSDK$endSyncReaction$1(r1));
        if (r2 == null) goto L7;
        r2.subscribe();
    L7:
        com.bytedance.ee.bear.rn.middleground.business.reaction.a r3 = this.d;
        this.d = null;
        if (r3 == null) goto L11;
        tt5.a.h("ReactionSDK", "unregisterCommentDataObserver, temp: " + r3.hashCode());
        RnSyncManager r4 = RnSyncManager.a;
        RnSyncManager.q(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final void b(e r2) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
    }

    public ReactionSDK(String r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "docToken");
        Intrinsics.checkNotNullParameter(r4, "documentType");
        this.a = r3;
        this.b = r4;
        this.c = new yl5.a("common:" + this.a + ':' + this.b.b + ':' + this.b.getType());
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final Flowable<String> d(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "replyId");
        Intrinsics.checkNotNullParameter(r12, "reactionKey");
        final String r0 = b.a();
        ReactionProtocol.AddReaction r1 = new ReactionProtocol.AddReaction();
        r1.setHeader(new Protocol.Entity.Header(r0));
        r1.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        r1.setBody(new ReactionProtocol.Body.AddReaction(r11, r12));
        final String r13 = r1.getJsonString();
        return b.b(new ReactionSDK$addReaction$1(r13, r0));
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final Flowable<String> f(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "replyId");
        Intrinsics.checkNotNullParameter(r12, "reactionKey");
        final String r0 = b.a();
        ReactionProtocol.RemoveReaction r1 = new ReactionProtocol.RemoveReaction();
        r1.setHeader(new Protocol.Entity.Header(r0));
        r1.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        r1.setBody(new ReactionProtocol.Body.RemoveReaction(r11, r12));
        final String r13 = r1.getJsonString();
        return b.b(new ReactionSDK$removeReaction$1(r13, r0));
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final Flowable<String> g(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "referType");
        Intrinsics.checkNotNullParameter(r12, "referKey");
        final String r0 = b.a();
        ReactionProtocol.ReactionDetail r1 = new ReactionProtocol.ReactionDetail();
        r1.setHeader(new Protocol.Entity.Header(r0));
        r1.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        r1.setBody(new ReactionProtocol.Body.GetReactionDetail(r11, r12));
        final String r13 = r1.getJsonString();
        return b.b(new ReactionSDK$getDetailReaction$1(r13, r0));
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final void y(Comment.g r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "observer");
        if (r10 == true) goto L5;
    L9:
        com.bytedance.ee.bear.rn.middleground.business.reaction.a r11 = this.d;
        if (r11 == null) goto L12;
        tt5.a.h("ReactionSDK", "registerReactionObserver, unregister last mRealObserver: " + r11.hashCode());
        RnSyncManager r1 = RnSyncManager.a;
        RnSyncManager.q(r11);
    L12:
        com.bytedance.ee.bear.rn.middleground.business.reaction.a r12 = new com.bytedance.ee.bear.rn.middleground.business.reaction.a(this, r9);
        this.d = r12;
        StringBuilder r2 = new StringBuilder("registerReactionObserver, observer: ");
        r2.append(r9.hashCode());
        r2.append(", realObserver: ");
        r2.append(r12.hashCode());
        r2.append(", mRealObserver: ");
        com.bytedance.ee.bear.rn.middleground.business.reaction.a r13 = this.d;
        if (r13 == null) goto L15;
        Integer r14 = Integer.valueOf(r13.hashCode());
    L16:
        r2.append(r14);
        tt5.a.h("ReactionSDK", r2.toString());
        RnSyncManager r15 = RnSyncManager.a;
        RnSyncManager.h(r12);
        return;
    L15:
        r14 = null;
        goto L16
    L5:
        if (this.c.b() > 1) goto L9;
        ReactionProtocol.BeginSync r16 = new ReactionProtocol.BeginSync();
        r16.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        final String r17 = r16.getJsonString();
        Flowable<String> r18 = b.b(new ReactionSDK$beginSyncReaction$1(r17));
        if (r18 == null) goto L9;
        r18.subscribe();
        goto L9
    }

    @Override // com.bytedance.ee.bear.rn.k
    public final Flowable<String> e(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "referType");
        Intrinsics.checkNotNullParameter(r12, "referKey");
        final String r0 = b.a();
        ReactionProtocol.DetailPanelStatus r1 = new ReactionProtocol.DetailPanelStatus();
        r1.setHeader(new Protocol.Entity.Header(r0));
        r1.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        r1.setBody(new ReactionProtocol.Body.DetailPanelStatus(r11, r12, r13));
        final String r14 = r1.getJsonString();
        return b.b(new ReactionSDK$setDetailReaction$1(r14, r0));
    }
}

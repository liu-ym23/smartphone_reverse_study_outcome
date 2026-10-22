package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.PostCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends vv4.a implements tb5.i<LikeListJsData> {
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2.-CC.$default$authType(this);
    }

    public k() {
    }

    public final void onAttachToWeb(vv4.k r1) {
        super.onAttachToWeb(r1);
        bindBridgeHandlerAutoUnbind("biz.util.openlikesList", this);
    }

    public final void handle(Object r3, tb5.m r4) {
        LikeListJsData r5 = (LikeListJsData) r3;
        tt5.a.h("LikeListLaunchWebService", "handle: " + r5);
        if (r5 == null) goto L6;
        int r6 = p.a;
        String r7 = r5.getToken();
        int r8 = r5.getRefer_type();
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/doc/like/activity");
        int r1 = LikeListActivity.n;
        r0.i("doc_token", r7).j("ref_type", r8).i("from", "from_click").e();
        return;
    }
}

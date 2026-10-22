package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements ml.b {
    public final /* synthetic */ ECShopExplainCardPresenter a;

    public final String c() {
        String r0 = this.a.d0().getStoreAccountParam().getUserId();
        if (r0 != null) goto L8;
        StoreV3LiveRoomVO r1 = this.a.o;
        if (r1 == null) goto L7;
        r0 = r1.getAnchorId();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0;
    }

    public final String d() {
        String r0 = this.a.d0().getStoreAccountParam().getSecUserId();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String roomId() {
        StoreV3LiveRoomVO r0 = this.a.o;
        if (r0 == null) goto L6;
        String r1 = r0.getRoomId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public c(ECShopExplainCardPresenter r1) {
        this.a = r1;
    }
}

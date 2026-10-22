package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ AuctionCardPresenter a;

    public g(AuctionCardPresenter r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        int r5 = zg2.a.a;
        ExplainCardViewModel r6 = this.a.e;
        if (r6 == null) goto L7;
        ml.b r7 = r6.getLiveRoomInfo();
        if (r7 == null) goto L7;
        String r8 = r7.roomId();
    L8:
        ExplainCardViewModel r0 = this.a.e;
        if (r0 == null) goto L13;
        RoomContextController r1 = r0.getRoomContextController();
        if (r1 == null) goto L13;
        String r2 = r1.D();
    L14:
        zg2.a.a(r8, r2, Action.GOODS_CARD_PIC_FAIL, null);
        return;
    L13:
        r2 = null;
    L7:
        r8 = null;
        goto L8
    }
}

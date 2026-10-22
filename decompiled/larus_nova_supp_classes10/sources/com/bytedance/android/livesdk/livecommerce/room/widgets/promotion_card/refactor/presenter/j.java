package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ AuctionV2CardPresenter a;

    public j(AuctionV2CardPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        ExplainCardViewModel r15 = this.a.e;
        ECUIPromotion r0 = null;
        if (r15 == null) goto L7;
        cf.c r16 = r15.getBtmInfo();
        if (r16 == null) goto L7;
        String r5 = r16.b();
    L8:
        ExplainCardViewModel r17 = this.a.e;
        if (r17 == null) goto L19;
        RoomContextController r18 = r17.getRoomContextController();
        if (r18 == null) goto L19;
        RealRoomController r19 = r18.A();
        if (r19 == null) goto L19;
        EntryController r110 = r19.t;
        if (r110 == null) goto L19;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c r111 = r110.K();
        if (r111 == null) goto L19;
        LiveActionTracker r9 = r111.a("livesdk_live_room", null);
    L20:
        AuctionV2CardPresenter r112 = this.a;
        ExplainCardViewModel r1 = r112.e;
        if (r1 == null) goto L23;
        ExplainCardViewModel.clickAuctionV2Card$default(r1, r112.u().c(), "button", false, r5, null, BtmSDK.INSTANCE.getPageId(PageFinder.via(this.a.w().f())), this.a.w().f(), r9, null, 276, null);
    L23:
        ExplainCardViewModel r113 = this.a.e;
        if (r113 == null) goto L40;
        QLiveData<ECUIPromotion> r114 = r113.getPromotionState();
        if (r114 == null) goto L41;
        ECUIPromotion r115 = (ECUIPromotion) r114.a();
        if (r115 == null) goto L42;
        ECAuctionInfo r116 = r115.auctionV2;
        if (r116 != null) goto L32;
        return;
    L32:
        if (r116.getStatus() != 1) goto L44;
        AuctionV2CardPresenter r117 = this.a;
        String r2 = ECLiveABUtils.INSTANCE.getEC_LIVE_AUCTION_CARD_REPORT_PATH();
        ExplainCardViewModel r3 = this.a.e;
        if (r3 == null) goto L38;
        QLiveData<ECUIPromotion> r4 = r3.getPromotionState();
        if (r4 == null) goto L38;
        r0 = (ECUIPromotion) r4.a();
    L38:
        AuctionV2CardPresenter.E(r117, r2, r0);
        return;
    L44:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L19:
        r9 = null;
    L7:
        r5 = null;
        goto L8
    }
}

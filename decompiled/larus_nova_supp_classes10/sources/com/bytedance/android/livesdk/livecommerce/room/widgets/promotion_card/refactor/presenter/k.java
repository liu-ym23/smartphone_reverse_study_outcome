package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ AuctionV2CardPresenter a;

    public k(AuctionV2CardPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        ExplainCardViewModel r15 = this.a.e;
        ECUIPromotion r0 = null;
        if (r15 == null) goto L7;
        cf.c r16 = r15.getBtmInfo();
        if (r16 == null) goto L7;
        String r17 = r16.a();
    L8:
        if (r17 != null) goto L10;
        r17 = "";
    L10:
        String r5 = r17;
        ExplainCardViewModel r18 = this.a.e;
        if (r18 == null) goto L21;
        RoomContextController r19 = r18.getRoomContextController();
        if (r19 == null) goto L21;
        RealRoomController r110 = r19.A();
        if (r110 == null) goto L21;
        EntryController r111 = r110.t;
        if (r111 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c r112 = r111.K();
        if (r112 == null) goto L21;
        LiveActionTracker r9 = r112.a("livesdk_live_room", null);
    L22:
        PageFinder r113 = PageFinder.via(this.a.y());
        BcmParams r1 = new BcmParams();
        r1.put("bst_group_type", "live");
        Unit r2 = Unit.INSTANCE;
        EcomBcmTracker.j(r113, r1);
        AuctionV2CardPresenter r114 = this.a;
        ExplainCardViewModel r3 = r114.e;
        if (r3 == null) goto L25;
        ExplainCardViewModel.clickAuctionV2Card$default(r3, r114.u().c(), "blank", false, r5, new BtmItemBuilder(r5, Boolean.TRUE).withView(this.a.y()), BtmSDK.INSTANCE.getPageId(PageFinder.via(this.a.w().f())), this.a.y(), r9, null, 260, null);
    L25:
        AuctionV2CardPresenter r115 = this.a;
        String r4 = ECLiveABUtils.INSTANCE.getEC_LIVE_AUCTION_CARD_REPORT_PATH();
        ExplainCardViewModel r6 = this.a.e;
        if (r6 == null) goto L30;
        QLiveData<ECUIPromotion> r7 = r6.getPromotionState();
        if (r7 == null) goto L30;
        r0 = (ECUIPromotion) r7.a();
    L30:
        AuctionV2CardPresenter.E(r115, r4, r0);
        return;
    L21:
        r9 = null;
    L7:
        r17 = null;
        goto L8
    }
}

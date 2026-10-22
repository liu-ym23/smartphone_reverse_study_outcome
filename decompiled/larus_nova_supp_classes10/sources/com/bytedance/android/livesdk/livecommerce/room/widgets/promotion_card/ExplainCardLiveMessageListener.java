package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RoomTagOfflineInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.CustomExplainCardShowStrategy;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainCardLiveMessageListener implements o {
    public final CustomExplainCardShowStrategy a;
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i b;
    public final String c;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.n d;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        PromotionListController.a r0 = PromotionListController.T;
        String r1 = this.c;
        String r2 = this.d.D();
        r0.getClass();
        fh2.a r3 = PromotionListController.a.b(r1, r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (((LivePromotionListFragment) r3).p() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void a(e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        dm.a.a("ExplainCardShowStrategy").i("Received refresh msg, isListShowing = " + b());
        this.a.n(r5, b(), false, ExplainCardLiveMessageListener$refreshPromotion$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void d(f0 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        dm.a.a("ExplainCardShowStrategy").i("Received update msg, isListShowing = " + b());
        this.a.l(r5, b(), false, ExplainCardLiveMessageListener$updatePromotion$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void h(si2.z r6) {
        if (r6 == null) goto L21;
        ECV2AuctionInfo r0 = r6.auctionInfo;
        if (r0 == null) goto L21;
        ExplainCardViewModel r1 = this.b.j();
        if (r1 == null) goto L21;
        QLiveData<ECUIPromotion> r2 = r1.getPromotionState();
        if (r2 == null) goto L21;
        ECUIPromotion r3 = (ECUIPromotion) r2.a();
        if (r3 == null) goto L21;
        ECUICampaign r4 = r3.campaign;
        if (r4 == null) goto L20;
        ECPromotionAuctionInfo r5 = r4.auctionInfo;
        if (r5 == null) goto L16;
        String r7 = r5.getProductId();
    L18:
        if (Intrinsics.areEqual(r7, String.valueOf(r0.productId)) == false) goto L20;
        r3.setAuctionInfo(r0.toECPromotionAuctionInfo());
        ECUICampaign r8 = r3.campaign;
        r8.auctionInfo = r0.toECPromotionAuctionInfo();
        goto L20
    L16:
        r7 = null;
    L20:
        this.b.f(r3);
    L21:
        if (r6 == null) goto L26;
        ECV2AuctionSuccess r9 = r6.auctionSuccess;
        if (r9 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.a.a(this.b.n(), r9);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void i(ECV2RoomTagOfflineInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "roomTagOfflineInfo");
        dm.a.a("ExplainCardShowStrategy").i("Received refresh msg, isListShowing = " + b());
        this.a.e(b());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void j(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        dm.a.a("ExplainCardShowStrategy").i("Received appear msg, isListShowing = " + b());
        this.a.b(r4, b(), null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o
    public final void k(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        dm.a.a("ExplainCardShowStrategy").i("Received disappear msg, isListShowing = " + b());
        this.a.p(r4, b());
    }

    public ExplainCardLiveMessageListener(Context r10, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r11, String r12, com.bytedance.android.livesdk.livecommerce.room.controller.business.n r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r13, "explainCardController");
        this.b = r11;
        this.c = r12;
        this.d = r13;
        com.bytedance.android.livesdk.livecommerce.room.utils.g r6 = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r13, "explainCardController");
        CustomExplainCardShowStrategy r0 = new CustomExplainCardShowStrategy(r10, r11, r6, r12, r13);
        r13.j = r0;
        Unit r14 = Unit.INSTANCE;
        this.a = r0;
    }
}

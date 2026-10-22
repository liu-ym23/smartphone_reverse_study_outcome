package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionCardProductRefreshHandler extends ProductRefreshMessageHandler {
    public final i c;
    public final String d;
    public final Function0<String> e;

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final int a() {
        return 2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final int b() {
        if (this.c.i().v() == false) goto L6;
        return 2;
    L6:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_POP_RECV_REFRESH() != 1) goto L15;
        ExplainCardViewModel r0 = this.c.j();
        if (r0 == null) goto L12;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L12;
        ECUIPromotion r2 = (ECUIPromotion) r1.a();
    L13:
        if (r2 != null) goto L15;
        return 3;
    L12:
        r2 = null;
    L15:
        return 1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final boolean c(int r3) {
        if (r3 == 3) goto L5;
    L8:
        return true;
    L5:
        if (b() == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final void d(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        ExplainCardViewModel r5 = this.c.j();
        if (r5 == null) goto L10;
        QLiveData<ECUIPromotion> r6 = r5.getPromotionState();
        if (r6 == null) goto L11;
        ECUIPromotion r7 = (ECUIPromotion) r6.a();
        if (r7 == null) goto L12;
        this.c.f(r7);
        v r8 = new v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        r8.c("promotion_id", r3);
        r8.c("use_new_message", "1");
        r8.c("scene", "promotion_card");
        r8.c("handled", "1");
        r8.i(null);
        return;
    L12:
        return;
    L11:
        return;
    }

    public PromotionCardProductRefreshHandler(i r2, String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r4, "lastExplainPromotionId");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final void f(String r2, Map<String, String> r3, List<String> r4, final Function1<? super ql.a, Unit> r5, RoomContextController r6) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "extraParams");
        Intrinsics.checkNotNullParameter(r4, "promotionIds");
        int r7 = f.a;
        f.b(this.d, r2, r3, r6, new PromotionCardProductRefreshHandler$requestPromotionByApi$1(this, r5));
    }
}

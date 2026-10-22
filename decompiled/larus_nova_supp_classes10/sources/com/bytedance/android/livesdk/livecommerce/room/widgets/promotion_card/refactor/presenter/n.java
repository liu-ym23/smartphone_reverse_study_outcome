package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionPopHeader;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ECPromotionPopHeader g;
    public final /* synthetic */ BackgroundPresenter h;
    public final /* synthetic */ ECUIPromotion i;

    public final void a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "v");
        BackgroundPresenter r0 = this.h;
        ECUIPromotion r1 = this.i;
        r0.getClass();
        int r2 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ExplainCardViewModel r3 = r0.e;
        String r4 = null;
        if (r3 == null) goto L7;
        ml.b r5 = r3.getLiveRoomInfo();
        if (r5 == null) goto L7;
        String r6 = r5.roomId();
    L8:
        ExplainCardViewModel r7 = r0.e;
        if (r7 == null) goto L13;
        Function0<Map<String, Map<String, String>>> r8 = r7.getEventPassthroughParams();
        if (r8 == null) goto L13;
        Map r9 = (Map) r8.invoke();
    L14:
        ExplainCardViewModel r10 = r0.e;
        if (r10 == null) goto L17;
        RoomContextController r12 = r10.getRoomContextController();
    L18:
        Intrinsics.checkNotNullParameter(r1, "uiPromotion");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECCardBannerExplainStatusClickEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.e(r1, ControllerExtensionsKt.c(r12, r6), r9));
        xh.c.a("Live").d("explain_card", "explain_card_source_3d", MapsKt.mapOf(TuplesKt.to("promotion_id", r1.getPromotionId())));
        boolean r13 = !this.g.isSampleRoom();
        ExplainCardViewModel r14 = this.h.e;
        if (r14 == null) goto L23;
        cf.c r15 = r14.getBtmInfo();
        if (r15 == null) goto L23;
        r4 = r15.d();
    L23:
        BackgroundPresenter r16 = this.h;
        ExplainCardViewModel r17 = r16.e;
        if (r17 == null) goto L29;
        jf.d r18 = ExplainCardViewModel.getNewJumpDispatcher$default(r17, r16.u().c(), BtmSDK.INSTANCE.getPageId(PageFinder.via(this.h.w().f())), false, 4, null);
        if (r18 == null) goto L30;
        r18.c(this.h.u().c(), this.g.getJumpUrl(), BtmUtilsKt.e(r4, PageFinder.via(r11)), r13);
        return;
    L30:
        return;
    L29:
        return;
    L17:
        r12 = null;
    L13:
        r9 = null;
    L7:
        r6 = null;
        goto L8
    }

    public n(ECPromotionPopHeader r1, BackgroundPresenter r2, ECUIPromotion r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        super(null, "bind_key_live_cart_card", 1);
    }
}

package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements cf.a {
    public final /* synthetic */ LiveRoomParams a;
    public final /* synthetic */ sl.d b;
    public final /* synthetic */ il2.a c;
    public final /* synthetic */ ECUIPromotion d;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ View g;

    public static final class a implements zk.b {
        public a() {
        }

        public final String entryName() {
            return "live_pop_card_buy_to_add";
        }

        public final String getCouponId() {
            return null;
        }
    }

    public final jf.e a() {
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void onFailed() {
        Context r0 = this.f;
        sl.d r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L6:
        UIUtils.displayToast(r0, r2);
        il2.a r3 = this.c;
        if (r3 == null) goto L12;
        il2.a r4 = il2.a.C0145a.a(r3, "add_cart_directly", null, false, "add_cart_callback_fail", null, null, 48);
        if (r4 == null) goto L13;
        ((LiveActionTracker) r4).e(false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public t(LiveRoomParams r1, sl.d r2, il2.a r3, ECUIPromotion r4, com.bytedance.android.btm.api.model.d r5, Context r6, View r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void b(int r25, String r26, String r27, String r28, Integer r29, String r30, String r31, Integer r32, String r33) {
        Intrinsics.checkNotNullParameter(r33, "addType");
        com.bytedance.android.btm.api.model.d r1 = this.e;
        String r2 = null;
        if (r1 == null) goto L5;
        PromotionListController.c r18 = new PromotionListController.c(null, false, null, null, BtmSDK.INSTANCE.createJumpSourceBtmToken(r1), null, null, null, 239);
    L6:
        PromotionListController.a r3 = PromotionListController.T;
        LiveRoomParams r4 = this.a;
        if (r4 == null) goto L9;
        String r5 = r4.getRoomId();
    L10:
        LiveRoomParams r6 = this.a;
        if (r6 == null) goto L13;
        String r7 = r6.getRoomUniqueKey();
    L14:
        r3.getClass();
        PromotionListController r14 = PromotionListController.a.c(r5, r7);
        Context r15 = this.f;
        a r17 = new a();
        String r8 = this.d.getProductId();
        sl.d r9 = this.b;
        if (r9 == null) goto L17;
        r2 = r9.b();
    L17:
        PromotionListController.N(r14, r15, "live_pop_card_buy_to_add", r17, r18, false, new wj2.g.a(r8, r2), null, null, 192);
        il2.a r10 = this.c;
        if (r10 == null) goto L23;
        il2.a r11 = il2.a.C0145a.a(r10, "add_cart_directly", null, false, null, null, null, 62);
        if (r11 == null) goto L24;
        ((LiveActionTracker) r11).e(false);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r18 = null;
        goto L6
    }
}

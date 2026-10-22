package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_list_open", description = "打开商列", service = {"LiveList"})
public final class r extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public r() {
        this.a = new tg2.a("ListShow");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r23, JSONObject r24, Object r25, il2.a r26, com.bytedance.android.livesdk.livecommerce.ability.e r27) {
        JSONObject r2 = r24;
        boolean r3 = false;
        if (r23 == null) goto L48;
        if (r2 == null) goto L48;
        String r5 = r2.optString("room_id");
        String r6 = r2.optString("room_unique_key");
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        this.a.a("room_id is null!");
    L15:
        Object r8 = r25;
        String r9 = null;
        if ((r8 instanceof gi2.a) == true) goto L18;
        r8 = null;
    L18:
        gi2.a r10 = (gi2.a) r8;
        if (r10 == null) goto L22;
        com.bytedance.android.shopping.ligo.context.b<?> r11 = r10.a;
        if (r11 == null) goto L22;
    L24:
        if (r2.optBoolean("show_goods_list", false) == false) goto L32;
        if (r11 == null) goto L29;
        r11.g(new we3.b.a(true));
        if (r27 == null) goto L52;
        r27.onSuccess();
        return;
    L52:
        return;
    L29:
        logE("cannot find ligoContext of controller");
        if (r27 == null) goto L54;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r27, 0, "cannot find ligoContext of controller", 1);
        return;
    L54:
        return;
    L32:
        String r12 = r2.optString("open_method");
        String r13 = r2.optString("coupon_id");
        String r14 = r2.optString("entry_name");
        String r15 = r2.optString("extra_entrance_info");
        if (r15.length() <= 0) goto L35;
        boolean r16 = true;
    L36:
        if (r16 == true) goto L39;
        r15 = null;
    L39:
        String r17 = r2.optString("unique_index");
        if (r17.length() <= 0) goto L42;
        r3 = true;
    L42:
        if (r3 == false) goto L44;
        r9 = r17;
    L44:
        String r18 = r2.optString("promotion_id");
        boolean r19 = r2.optBoolean("is_promotion_id", true);
        String r110 = r2.optString("pass_through_params");
        String r111 = r2.optString("related_info");
        String r112 = r2.optString("source_btm_token");
        JSONObject r4 = r2.optJSONObject("live_room_info");
        JSONObject r113 = r2.optJSONObject("event_params");
        PromotionListController.T.getClass();
        PromotionListController.N(PromotionListController.a.c(r5, r6), r23, r12, new p(r13, r14, r15, r9), new PromotionListController.c(r18, r19, r110, r111, r112, new q(r4, r5), r113, null, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE), false, null, null, null, 240);
        if (r27 == null) goto L56;
        r27.onSuccess();
        return;
    L56:
        return;
    L35:
        r16 = false;
    L22:
        PromotionListController.T.getClass();
        r11 = PromotionListController.a.c(r5, r6).J;
        goto L24
    L9:
        if (r5.length() == 0) goto L12;
        r7 = false;
    L48:
        if (r27 == null) goto L50;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r27, 0, "context or params is null", 1);
    L50:
        logE("context or params is null");
    }
}

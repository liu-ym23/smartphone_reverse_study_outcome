package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "pop_card_show", description = "展示讲解卡", service = {"LiveCard"})
public final class f0 extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> {
    public static final String a = null;

    public static final class a {
    }

    static {
        a = f0.class.getSimpleName();
    }

    public f0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r6, JSONObject r7, Object r8, il2.a r9, com.bytedance.android.livesdk.livecommerce.ability.e r10) {
        JSONObject r11 = r7;
        if (r11 == null) goto L5;
        int r12 = r11.optInt("enable_cache", 0);
    L6:
        int r13 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r0 = ControllerCenter.c(null, null).q;
        Objects.toString(r0);
        cf.d r1 = r0.h;
        if ((r1 instanceof com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) == true) goto L9;
        r1 = null;
    L9:
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r2 = (com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) r1;
        int r3 = RoomContextController.h;
        ECContext r4 = RoomContextController.a.a().r();
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.n<ECUIPromotion> r5 = r4.getExplainPromotion();
        if (r5 == null) goto L14;
        ECUIPromotion r14 = (ECUIPromotion) r5.getValue();
    L15:
        dm.a.b r15 = dm.a.a;
        dm.a.b r16 = dm.a.a(a);
        StringBuilder r17 = new StringBuilder("execute ShowPopCard ability, params=");
        r17.append(r11);
        r17.append(", cachePromotionId=");
        if (r14 == null) goto L18;
        String r18 = r14.getPromotionId();
    L19:
        r17.append(r18);
        r17.append(", title=");
        if (r14 == null) goto L22;
        String r19 = r14.title;
    L23:
        r17.append(r19);
        r16.a(r17.toString());
        if (r12 <= 0) goto L38;
        if (r14 == null) goto L38;
        if (r2 == null) goto L38;
        r14.appendExtraEventParams("pop_card_show_type", PromotionCategory.CATEGORY_TYPE_SECOND);
        int r20 = com.bytedance.android.livesdk.livecommerce.utils.l.a;
        Gson r21 = new Gson();     // Catch: Exception -> L30
        Object r22 = r21.fromJson(r21.toJson(r14), ECUIPromotion.class);     // Catch: Exception -> L30
    L32:
        ECUIPromotion r23 = (ECUIPromotion) r22;
        if (r23 == null) goto L40;
        r23.showTimestamp = Long.valueOf(System.currentTimeMillis());
        Map r24 = r23.getExtraEventParams();
        if (r24 == null) goto L37;
        String r25 = (String) r24.remove("card_exposure_time");
    L37:
        r2.o(r23, true, "auto_host", null);
    L40:
        if (r10 == null) goto L45;
        r10.onSuccess();
        return;
    L45:
        return;
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r22 = null;
    L38:
        if (r2 == null) goto L40;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i.a.a(r2, null, false, null, 127);
        goto L40
    L22:
        r19 = null;
        goto L23
    L18:
        r18 = null;
    L14:
        r14 = null;
        goto L15
    L5:
        r12 = 0;
        goto L6
    }
}

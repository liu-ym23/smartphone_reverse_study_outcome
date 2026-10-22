package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "pop_card_close", description = "关闭讲解卡", service = {"LiveCard"})
public final class l extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public l() {
        this.a = new tg2.a("CardClose");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r7, JSONObject r8, Object r9, il2.a r10, com.bytedance.android.livesdk.livecommerce.ability.e r11) {
        JSONObject r12 = r8;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r13 = null;
        if (r12 == null) goto L12;
        String r0 = r12.optString("promotion_id");
        if (r0 == null) goto L12;
        if (r0.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
    L13:
        if (r12 == null) goto L22;
        String r2 = r12.optString("product_id");
        if (r2 == null) goto L22;
        if (r2.length() <= 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
    L23:
        if (r12 == null) goto L25;
        String r4 = r12.optString("room_id");
    L26:
        if (r12 == null) goto L28;
        String r14 = r12.optString("room_unique_key");
    L29:
        String r5 = "try close card, roomId=" + r4 + ", promotionId=" + r0 + ", productId=" + r2;
        tg2.a r6 = this.a;
        if (r6.a == false) goto L32;
        dm.a.b r15 = dm.a.a;
        dm.a.a(r6.b).a(r5);
    L32:
        int r16 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r17 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r4, r14).h;
        if ((r17 instanceof com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) == false) goto L36;
        r13 = r17;
    L36:
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r18 = r13;
        if (r18 == null) goto L41;
        r18.k(r2, r0, false);
        if (r11 == null) goto L45;
        r11.onSuccess();
        return;
    L45:
        return;
    L41:
        logE("cannot find the corresponding card controller " + r4);
        if (r11 == null) goto L47;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r11, 0, "cannot find the corresponding card controller " + r4, 1);
        return;
    L47:
        return;
    L28:
        r14 = null;
        goto L29
    L25:
        r4 = null;
        goto L26
    L19:
        r3 = false;
    L22:
        r2 = null;
        goto L23
    L9:
        r1 = false;
    L12:
        r0 = null;
        goto L13
    }
}

package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_list_back_top", description = "商列返回顶部", service = {"LiveList"})
public final class n extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public n() {
        this.a = new tg2.a("ListBackTop");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r2, JSONObject r3, Object r4, il2.a r5, com.bytedance.android.livesdk.livecommerce.ability.e r6) {
        JSONObject r7 = r3;
        if (r2 == null) goto L24;
        if (r7 == null) goto L24;
        String r8 = r7.optString("room_id");
        String r9 = r7.optString("room_unique_key");
        if (r8 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        if (r10 == false) goto L16;
        this.a.a("room_id is null");
    L16:
        if ((r4 instanceof PromotionCategory) == true) goto L18;
        r4 = null;
    L18:
        PromotionCategory r11 = (PromotionCategory) r4;
        PromotionListController.T.getClass();
        fh2.a r12 = PromotionListController.a.b(r8, r9);
        if (r12 == null) goto L23;
        ((LivePromotionListFragment) r12).ka0(r11);
        if (r6 == null) goto L26;
        r6.onSuccess();
        return;
    L26:
        return;
    L23:
        b(r6, "cannot find list controller of room_id " + r8);
        return;
    L9:
        if (r8.length() == 0) goto L12;
        r10 = false;
    L24:
        b(r6, "context or params is null");
    }
}

package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_list_close", description = "关闭商列", service = {"LiveList"})
public final class k extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public k() {
        this.a = new tg2.a("ListShow");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r5, JSONObject r6, Object r7, il2.a r8, com.bytedance.android.livesdk.livecommerce.ability.e r9) {
        JSONObject r10 = r6;
        if (r5 == null) goto L35;
        if (r10 == null) goto L35;
        String r11 = r10.optString("room_id");
        String r1 = r10.optString("room_unique_key");
        if (r11 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        this.a.a("room_id is null!");
    L16:
        if ((r7 instanceof gi2.a) == true) goto L18;
        r7 = null;
    L18:
        gi2.a r12 = (gi2.a) r7;
        if (r12 == null) goto L22;
        com.bytedance.android.shopping.ligo.context.b<?> r13 = r12.a;
        if (r13 == null) goto L22;
    L24:
        if (r10.optBoolean("hiden_goods_list", false) == false) goto L32;
        if (r13 == null) goto L29;
        r13.g(new we3.b.a(false));
        if (r9 == null) goto L39;
        r9.onSuccess();
        return;
    L39:
        return;
    L29:
        logE("cannot find ligoContext of controller");
        if (r9 == null) goto L41;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "cannot find ligoContext of controller", 1);
        return;
    L41:
        return;
    L32:
        if (r13 == null) goto L43;
        r13.g(new we3.b.b());
        return;
    L43:
        return;
    L22:
        PromotionListController.T.getClass();
        r13 = PromotionListController.a.c(r11, r1).J;
        goto L24
    L9:
        if (r11.length() == 0) goto L12;
        r2 = false;
    L35:
        if (r9 == null) goto L37;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "context or params is null", 1);
    L37:
        logE("context or params is null");
    }
}

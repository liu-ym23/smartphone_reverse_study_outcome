package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_list_refresh", description = "刷新商列", service = {"LiveList"})
public final class v extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public v() {
        this.a = new tg2.a("ListRefresh");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r5, JSONObject r6, Object r7, il2.a r8, com.bytedance.android.livesdk.livecommerce.ability.e r9) {
        JSONObject r10 = r6;
        if (r5 == null) goto L44;
        if (r10 == null) goto L44;
        String r11 = r10.optString("room_id");
        String r1 = r10.optString("room_unique_key");
        if (r11 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        this.a.a("room_id is null");
    L16:
        if ((r7 instanceof gi2.a) == true) goto L18;
        r7 = null;
    L18:
        gi2.a r12 = (gi2.a) r7;
        if (r12 == null) goto L22;
        com.bytedance.android.shopping.ligo.context.b<?> r13 = r12.a;
        if (r13 == null) goto L22;
    L23:
        if (r13 != null) goto L27;
        if (r9 == null) goto L26;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "cannot find ligoContext of current room", 1);
    L26:
        logE("ligoContext is null");
        return;
    L27:
        int r14 = r10.optInt("refresh_type", 0);
        tg2.a r3 = this.a;
        r3.getClass();
        dm.a.b r4 = dm.a.a;
        dm.a.a(r3.b).i("refresh type is " + r14);
        if (r14 != LiveListAtomicRefreshType.SILENCE.getValue()) goto L31;
        r13.g(new we3.b.c(false, false, 6));
    L39:
        if (r9 == null) goto L49;
        r9.onSuccess();
        return;
    L49:
        return;
    L31:
        if (r14 != LiveListAtomicRefreshType.SILENCE_RESET_TO_ALL_TAB.getValue()) goto L34;
        r13.g(new we3.b.c(false, true, true));
        goto L39
    L34:
        if (r14 != LiveListAtomicRefreshType.LOADING_RESET.getValue()) goto L37;
        r13.g(new we3.b.c(true, false, 6));
        goto L39
    L37:
        if (r14 != LiveListAtomicRefreshType.SILENCE_RESET_TO_TOP.getValue()) goto L41;
        r13.g(new we3.b.c(false, true, 4));
        goto L39
    L41:
        if (r9 == null) goto L51;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "unsupported refresh type " + r14 + '!', 1);
        return;
    L51:
        return;
    L22:
        PromotionListController.T.getClass();
        r13 = PromotionListController.a.c(r11, r1).J;
        goto L23
    L9:
        if (r11.length() == 0) goto L12;
        r2 = false;
    L44:
        if (r9 == null) goto L46;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "context or params is null", 1);
    L46:
        logE("context or params is null");
    }
}

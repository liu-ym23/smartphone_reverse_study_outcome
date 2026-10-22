package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "card_jump_to_order", description = "讲解卡跳转提单", service = {"LiveBase"})
public final class f extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public f() {
        this.a = new tg2.a("JumpOrder");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r19, JSONObject r20, Object r21, il2.a r22, com.bytedance.android.livesdk.livecommerce.ability.e r23) {
        JSONObject r2 = r20;
        if (r19 == null) goto L59;
        if (r2 == null) goto L59;
        String r5 = r2.optString("room_id");
        String r6 = r2.optString("room_unique_key");
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        this.a.a("room_id is null!");
    L15:
        String r10 = r2.optString("btm_id");
        String r12 = r2.optString("btm_page_id");
        if (r10.length() != 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L23;
        logE("btm_id is empty");
        if (r23 == null) goto L63;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r23, 0, "btm_id is empty", 1);
        return;
    L63:
        return;
    L23:
        int r4 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        cf.d r8 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r5, r6).h;
        if (r8 == null) goto L26;
        Object r9 = r21;
        if ((r9 instanceof View) == true) goto L32;
        r9 = null;
    L32:
        View r11 = (View) r9;
        if (r11 != null) goto L35;
        r11 = r8.getView();
    L35:
        View r13 = r11;
        if (r10.length() <= 0) goto L38;
        boolean r14 = true;
    L39:
        if (r14 == false) goto L41;
        String r15 = r10;
    L42:
        if (r15 == null) goto L44;
        BtmItemBuilder r16 = new BtmItemBuilder(r15, Boolean.TRUE).withView(r13);
    L46:
        if ((r8 instanceof com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) == true) goto L48;
        r8 = null;
    L48:
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r17 = (com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) r8;
        if (r17 == null) goto L55;
        ExplainCardViewModel r18 = r17.j();
        if (r18 == null) goto L55;
        ExplainCardViewModel.clickCard$default(r18, r18, r19, "button", false, r10, r16, r12, r13, r22, null, 520, null);
        if (r23 == null) goto L66;
        r23.onSuccess();
        return;
    L66:
        return;
    L55:
        logE("cannot find viewModel of explain card");
        if (r23 == null) goto L68;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r23, 0, "cannot find viewModel of explain card", 1);
        return;
    L68:
        return;
    L44:
        r16 = null;
        goto L46
    L41:
        r15 = null;
        goto L42
    L38:
        r14 = false;
        goto L39
    L26:
        if (r23 == null) goto L28;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r23, 0, "cannot find the controller of card", 1);
    L28:
        logE("cannot find the controller of card");
        return;
    L18:
        r3 = false;
        goto L19
    L9:
        if (r5.length() == 0) goto L12;
        r7 = false;
    L59:
        if (r23 == null) goto L61;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r23, 0, "context or params is null", 1);
    L61:
        logE("context or params is null");
    }
}

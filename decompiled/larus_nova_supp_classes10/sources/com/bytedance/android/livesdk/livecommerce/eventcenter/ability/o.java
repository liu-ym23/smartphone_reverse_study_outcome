package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "change_list_component_visibility", description = "改变商列组件显隐性", service = {"LiveList"})
public final class o extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public o() {
        this.a = new tg2.a("ListVisibility");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r5, JSONObject r6, Object r7, il2.a r8, com.bytedance.android.livesdk.livecommerce.ability.e r9) {
        JSONObject r10 = r6;
        if (r5 == null) goto L56;
        if (r10 == null) goto L56;
        String r11 = r10.optString("room_id");
        boolean r12 = true;
        if (r11 != null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        fh2.a r1 = null;
        if (r0 == false) goto L16;
        o r2 = this;
    L17:
        if (r2 == null) goto L19;
        this.a.a("room_id is null");
    L19:
        String r3 = r10.optString("room_unique_key");
        if (r3 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == false) goto L28;
        o r13 = this;
    L29:
        if (r13 == null) goto L31;
        this.a.a("room_unique_key is null");
    L31:
        String r14 = r10.optString("component");
        if (r14 != null) goto L34;
    L37:
        if (r12 == false) goto L39;
        o r15 = this;
    L40:
        if (r15 == null) goto L58;
        b(r9, "component is null");
        return;
    L58:
        boolean r16 = JSONObjectProtectorUtils.getBoolean(r10, "visible");     // Catch: Exception -> L54
        boolean r17 = r10.optBoolean("reset_state", false);
        PromotionListController.T.getClass();
        fh2.a r18 = PromotionListController.a.b(r11, r3);
        if (r18 != null) goto L46;
        b(r9, "cannot find live list instance of room_id[" + r11 + ']');
        Unit r19 = Unit.INSTANCE;
        return;
    L46:
        if (((LivePromotionListFragment) r18).p() == false) goto L48;
        r1 = r18;
    L48:
        if (r1 == null) goto L52;
        ((LivePromotionListFragment) r1).X90(r14, r16, r17);
        if (r9 == null) goto L61;
        r9.onSuccess();
        return;
    L61:
        return;
    L52:
        b(r9, "live list instance of room_id[" + r11 + "] is hidden");
        Unit r20 = Unit.INSTANCE;
        return;
    L54:
        e = move-exception;
        ECExceptionMonitor.e(e);
        b(r9, "visibility of component is not specified");
        return;
    L39:
        r15 = null;
        goto L40
    L34:
        if (r14.length() == 0) goto L37;
        r12 = false;
        goto L37
    L28:
        r13 = null;
        goto L29
    L22:
        if (r3.length() == 0) goto L25;
        r4 = false;
        goto L26
    L16:
        r2 = null;
        goto L17
    L9:
        if (r11.length() == 0) goto L12;
        r0 = false;
    L56:
        b(r9, "context or params is null");
    }
}

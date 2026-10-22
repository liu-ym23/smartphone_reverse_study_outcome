package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_report_log", description = "上报埋点", service = {"LiveBase"})
public final class y extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public y() {
        this.a = new tg2.a("Log");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r5, JSONObject r6, Object r7, il2.a r8, com.bytedance.android.livesdk.livecommerce.ability.e r9) {
        JSONObject r10 = r6;
        if (r10 == null) goto L5;
        String r11 = r10.optString("event");
    L6:
        boolean r0 = false;
        if (r11 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        if (r9 == null) goto L35;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r9, 0, "event name is null", 1);
        return;
    L35:
        return;
    L16:
        JSONObject r3 = r10.optJSONObject("params");
        if (r3 == null) goto L19;
        Map r4 = z1.j(r3);
    L20:
        String r12 = r10.optString("btm_id");
        if (r12.length() != 0) goto L23;
        r0 = true;
    L23:
        if (r0 == false) goto L26;
        this.a.a("btm_id is null");
    L26:
        if ((r7 instanceof com.bytedance.android.ec.common.api.jump.model.a) == true) goto L28;
        r7 = null;
    L28:
        com.bytedance.android.ec.common.api.jump.model.a r13 = (com.bytedance.android.ec.common.api.jump.model.a) r7;
        if (r13 == null) goto L31;
        oh.a.a(new w(r13, r11, r4, r12));
    L32:
        if (r9 == null) goto L37;
        r9.onSuccess();
        return;
    L37:
        return;
    L31:
        oh.a.a(new x(r12, r11, r4));
        goto L32
    L19:
        r4 = null;
        goto L20
    L9:
        if (r11.length() == 0) goto L12;
        r2 = false;
        goto L13
    L5:
        r11 = null;
        goto L6
    }
}

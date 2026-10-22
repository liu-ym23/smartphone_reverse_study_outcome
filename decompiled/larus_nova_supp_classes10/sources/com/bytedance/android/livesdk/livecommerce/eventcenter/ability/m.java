package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_guide", description = "直播间导流参数拼接", service = {"LiveBase"})
public final class m extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public m() {
        this.a = new tg2.a("LiveGuide");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r17, JSONObject r18, Object r19, il2.a r20, com.bytedance.android.livesdk.livecommerce.ability.e r21) {
        JSONObject r3 = r18;
        int r0 = 0;
        if (r17 == null) goto L51;
        if (r3 == null) goto L51;
        String r6 = r3.optString("room_id");
        if (r6 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        this.a.a("room_id is null!");
    L15:
        String r8 = r3.optString("schema");
        if (r8 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L26;
        logE("schema is null");
        if (r21 == null) goto L62;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r21, 0, "schema is null", 1);
        return;
    L62:
        return;
    L26:
        String r9 = r3.optString("params_type");
        JSONArray r10 = r3.optJSONArray("user_act_params");     // Catch: Exception -> L38
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L38
        if (r10 == null) goto L37;
        int r12 = r10.length();     // Catch: Exception -> L38
    L30:
        if (r0 >= r12) goto L37;
        Object r13 = r10.get(r0);     // Catch: Exception -> L38
        if ((r13 instanceof Object) == true) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L36;
        r11.add(r13);     // Catch: Exception -> L38
    L36:
        r0 = r0 + 1;
    L37:
        List r14 = r11;
    L57:
        Map r1 = com.bytedance.android.shopping.extensions.k.z(JSONObjectProtectorUtils.getString(r3, "report_params"));     // Catch: Exception -> L44
        if ((r1 instanceof Map) == false) goto L46;
        Map r15 = r1;
    L47:
        com.bytedance.android.livesdk.livecommerce.params.a.b(r17, r6, null, r8, r9, false, r14, null, null, r15, 384);
        if (r21 == null) goto L64;
        r21.onSuccess();
        return;
    L64:
        return;
    L46:
        r15 = null;
    L44:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L38:
        e = move-exception;
        ECExceptionMonitor.e(e);
        logE("fail to get param [user_act_params]");
        r14 = CollectionsKt.emptyList();
        goto L57
    L18:
        if (r8.length() == 0) goto L21;
        r7 = false;
        goto L22
    L9:
        if (r6.length() == 0) goto L12;
        r5 = false;
    L51:
        if (r21 == null) goto L53;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r21, 0, "context or params is null", 1);
    L53:
        logE("context or params is null");
    }
}

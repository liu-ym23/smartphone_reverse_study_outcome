package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.iron.navigate.IronNavigator;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "open_product_detail", description = "直播间打开商详", service = {"LiveBase"})
public final class s extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public s() {
        this.a = new tg2.a("open_product_detail");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r10, JSONObject r11, Object r12, il2.a r13, com.bytedance.android.livesdk.livecommerce.ability.e r14) {
        JSONObject r15 = r11;
        if (r10 == null) goto L23;
        if (r15 == null) goto L23;
        String r1 = a2.d(r15.optString("room_id"));
        HashMap r16 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r17 = com.bytedance.android.ec.core.hybrid.utils.j.i(r15.optString("extra"));
        if (r17 == null) goto L11;
        String r18 = r17.optString("promotion_id");
        if (r18 == null) goto L11;
        String r3 = a2.d(r18);
    L12:
        if (r17 == null) goto L16;
        String r19 = r17.optString("request_additions");
        if (r19 == null) goto L16;
        String r6 = a2.d(r19);
    L17:
        com.bytedance.android.btm.api.model.d r7 = BtmUtilsKt.e(r15.optString("btm"), PageFinder.via(r15.optString("btm_page_id")));
        String r110 = r15.optString("passthrough_params");
        if (r110 == null) goto L20;
        JSONObject r5 = com.bytedance.android.ec.core.hybrid.utils.j.i(r110);
    L21:
        IronNavigator.g(r10, r1, r3, r3, null, r5, r6, r7, new bk2.b());
        return;
    L20:
        r5 = null;
    L16:
        r6 = null;
    L11:
        r3 = null;
    L23:
        if (r14 == null) goto L25;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r14, 0, "context or params is null", 1);
    L25:
        logE("context or params is null");
    }
}

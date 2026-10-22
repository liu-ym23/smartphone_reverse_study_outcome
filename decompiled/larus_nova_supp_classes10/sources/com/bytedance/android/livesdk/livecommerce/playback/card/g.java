package com.bytedance.android.livesdk.livecommerce.playback.card;

import cf.l;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements com.bytedance.android.livesdk.livecommerce.promotion.card.e {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;
    public final /* synthetic */ l b;

    public g(ExplainPlaybackCardPresenter r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.e
    public final boolean a(String r6, Map<String, String> r7, String r8, ql.a r9, Function3<? super String, ? super Map<String, String>, ? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "eventParams");
        Intrinsics.checkNotNullParameter(r10, "save");
        if (Intrinsics.areEqual(r6, "livesdk_show_product") == false) goto L26;
        cj2.c r11 = cj2.a.a;
        ECUIPromotion r12 = this.a.n;
        LinkedHashMap r0 = new LinkedHashMap();
        cj2.c r1 = cj2.a.a;
        if (r1 == null) goto L10;
        HashMap<String, String> r2 = r1.a;
        if (r2 == null) goto L10;
        r0.putAll(r2);
    L10:
        if (cj2.a.b == false) goto L12;
        String r3 = "1";
    L13:
        r0.put("subtitle_status", r3);
        cj2.c r4 = cj2.a.a;
        if (r4 == null) goto L16;
        r0.put("system_volume_pct", String.valueOf(Double.valueOf(r4.b).doubleValue()));
    L16:
        r0.put("end_volume_pct", String.valueOf(com.bytedance.android.ec.core.utils.g.a()));
        HashMap r5 = new HashMap();
        r5.put("card_status", "1");
        r5.put("ecom_entrance_form", "replay_popup_card");
        if (r12 == null) goto L21;
        String r13 = r12.getRealPrice();
        if (r13 == null) goto L21;
        r5.put("real_price", r13);
    L21:
        if (r12 == null) goto L25;
        String r14 = r12.getCostPrice();
        if (r14 == null) goto L25;
        r5.put("cost_price", r14);
    L25:
        r0.putAll(r5);
        Map r15 = MapsKt.toMutableMap(r0);
        r15.putAll(r7);
        Unit r16 = Unit.INSTANCE;
        r10.invoke(r6, r15, r8);
        return true;
    L12:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L13
    L26:
        return false;
    }
}

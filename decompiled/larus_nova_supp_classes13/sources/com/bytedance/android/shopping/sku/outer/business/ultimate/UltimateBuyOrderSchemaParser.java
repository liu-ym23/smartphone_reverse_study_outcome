package com.bytedance.android.shopping.sku.outer.business.ultimate;

import android.net.Uri;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyOrderExParams;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class UltimateBuyOrderSchemaParser {
    static {
    }

    @JvmStatic
    public static final UltimateBuyOrderExParams a(final Uri r6) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        Map r7 = MapsKt.toMap(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(UriProtector.getQueryParameterNames(r6)), UltimateBuyOrderSchemaParser$getParams$queryParams$1.INSTANCE), new UltimateBuyOrderSchemaParser$getParams$queryParams$2(r6)), new LinkedHashMap());
        String r0 = (String) r7.get("mega_object_id");
        if (r0 != null) goto L6;
        r0 = (String) r7.get("rifle_mega_object_id");
    L6:
        if (r0 == null) goto L9;
        HashMap r2 = j.a;
        JSONObject r1 = j.d(r0);
        if (r1 == null) goto L9;
    L13:
        if (r1 == null) goto L15;
        String r3 = r1.toString();
    L16:
        JSONObject r4 = new JSONObject();
        r4.put("biometric_params", "1");
        TTCJPayUtils.Companion r5 = TTCJPayUtils.Companion;
        r4.put("is_jailbreak", r5.getInstance().getJailBreak());
        r4.put("cj_sdk", r5.getInstance().getSDKVersion());
        r4.put("bio_type", r5.getInstance().getBioType());
        int r8 = p.a;
        r4.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r9 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r4.put("cj_pass_through_info", "");
        MapsKt.mapOf(TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW));
        p.a();
        r4.put("finance_risk", null);
        Unit r10 = Unit.INSTANCE;
        return new UltimateBuyOrderExParams(r7, r3, r4.toString());
    L15:
        r3 = null;
    L9:
        String r11 = (String) r7.get("mega_object");
        if (r11 == null) goto L12;
        r1 = k.w(r11);
        goto L13
    L12:
        r1 = null;
        goto L13
    }

    @JvmStatic
    public static final UltimateBuyOrderExParams b(IOrderSchema r6) {
        Intrinsics.checkNotNullParameter(r6, "orderSchema");
        r6.z0();
        Map r0 = r6.b();
        if (r0 == null) goto L7;
        Map r1 = MapsKt.toMutableMap(r0);
        if (r1 == null) goto L7;
        r1.put("use_new_self_event", String.valueOf(ECSettingKeys.k()));
        Unit r2 = Unit.INSTANCE;
    L8:
        String r7 = r6.a();
        JSONObject r3 = new JSONObject();
        r3.put("biometric_params", "1");
        TTCJPayUtils.Companion r4 = TTCJPayUtils.Companion;
        r3.put("is_jailbreak", r4.getInstance().getJailBreak());
        r3.put("cj_sdk", r4.getInstance().getSDKVersion());
        r3.put("bio_type", r4.getInstance().getBioType());
        int r5 = p.a;
        r3.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r8 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r3.put("cj_pass_through_info", "");
        MapsKt.mapOf(TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW));
        p.a();
        r3.put("finance_risk", null);
        Unit r9 = Unit.INSTANCE;
        return new UltimateBuyOrderExParams(r1, r7, r3.toString());
    L7:
        r1 = null;
        goto L8
    }
}

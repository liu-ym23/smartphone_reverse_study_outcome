package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends qf3.e {
    public final String getName() {
        return "ec.mallRequestShowResult";
    }

    public i(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r17, IBDXBridgeContext r18, Map<String, ? extends Object> r19, Map<String, Object> r20) {
        Intrinsics.checkNotNullParameter(r17, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "result");
        Object r10 = r19.get("canShow");
        Object r12 = null;
        if ((r10 instanceof Integer) == true) goto L5;
        r10 = null;
    L5:
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L8;
        int r13 = r11.intValue();
    L9:
        Object r0 = r19.get("bizParams");
        if ((r0 instanceof Map) == true) goto L12;
        r0 = null;
    L12:
        Map r1 = (Map) r0;
        if (r1 != null) goto L15;
        r1 = MapsKt.emptyMap();
    L15:
        Object r2 = r1.get("plan");
        if ((r2 instanceof String) == false) goto L19;
        r12 = r2;
    L19:
        String r14 = (String) r12;
        if (r14 != null) goto L22;
        r14 = "default";
    L22:
        if (r13 != 0) goto L58;
        if (Intrinsics.areEqual(r14, "default") == false) goto L26;
        int r3 = 6;
    L60:
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L59
        r15.put("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Throwable -> L59
        r15.put("plan", r14);     // Catch: Throwable -> L59
        r15.put("status", r3);     // Catch: Throwable -> L59
        r15.put("business_type", "shopping_product");     // Catch: Throwable -> L59
        r15.put("group_tag", "promote_consum");     // Catch: Throwable -> L59
        r15.put("type_tag", "Product_discounts");     // Catch: Throwable -> L59
        Map<String, Object> r4 = q93.a.a;     // Catch: Throwable -> L59
        Object r16 = ((LinkedHashMap) r4).get("templateTag");     // Catch: Throwable -> L59
        Object r110 = "";
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        r15.put("templateTag", r16);     // Catch: Throwable -> L59
        Object r9 = ((LinkedHashMap) r4).get("templateId");     // Catch: Throwable -> L59
        if (r9 != null) goto L34;
        r9 = "";
    L34:
        r15.put("templateId", r9);     // Catch: Throwable -> L59
        Object r8 = ((LinkedHashMap) r4).get("pushType");     // Catch: Throwable -> L59
        if (r8 != null) goto L37;
        r8 = "";
    L37:
        r15.put("pushType", r8);     // Catch: Throwable -> L59
        Object r7 = ((LinkedHashMap) r4).get("id");     // Catch: Throwable -> L59
        if (r7 != null) goto L40;
        r7 = "";
    L40:
        r15.put("id", r7);     // Catch: Throwable -> L59
        Object r6 = ((LinkedHashMap) r4).get("title");     // Catch: Throwable -> L59
        if (r6 != null) goto L43;
        r6 = "";
    L43:
        r15.put("title", r6);     // Catch: Throwable -> L59
        Object r5 = ((LinkedHashMap) r4).get("text");     // Catch: Throwable -> L59
        if (r5 != null) goto L46;
        r5 = "";
    L46:
        r15.put("text", r5);     // Catch: Throwable -> L59
        Object r21 = ((LinkedHashMap) r4).get("openUrl");     // Catch: Throwable -> L59
        if (r21 != null) goto L49;
        r21 = "";
    L49:
        r15.put("openUrl", r21);     // Catch: Throwable -> L59
        Object r22 = ((LinkedHashMap) r4).get("imageUrl");     // Catch: Throwable -> L59
        if (r22 != null) goto L52;
        r22 = "";
    L52:
        r15.put("imageUrl", r22);     // Catch: Throwable -> L59
        Object r23 = ((LinkedHashMap) r4).get("groupId");     // Catch: Throwable -> L59
        if (r23 == null) goto L56;
        r110 = r23;
    L56:
        r15.put("groupId", r110);     // Catch: Throwable -> L59
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L59
        AppLogNewUtils.onEventV3("iesec_mall_product_push_event", r15);     // Catch: Throwable -> L59
        goto L58
    L26:
        r3 = 7;
    L58:
        return qf3.e.f(this);
    L8:
        r13 = 1;
        goto L9
    }
}

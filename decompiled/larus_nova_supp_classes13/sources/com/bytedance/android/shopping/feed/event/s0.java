package com.bytedance.android.shopping.feed.event;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s0 {
    public static final Map<String, String> b(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L15;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
        if (r5 == null) goto L15;
        String r2 = r5.optString("anchor_detail_info");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put("anchor_detail_info", r2);
    L9:
        String r3 = r5.optString("is_label_show");
        if (TextUtils.isEmpty(r3) == true) goto L12;
        r0.put("is_label_show", r3);
    L12:
        String r6 = r5.optString("sellpoint_bp_video");
        if (TextUtils.isEmpty(r6) == true) goto L15;
        r0.put("sellpoint_bp_video", r6);
    L15:
        return r0;
    }

    public static final String c(rd3.a r3) {
        if (r3 == null) goto L30;
        yd3.p r1 = r3.i();
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.getType() != 12) goto L32;
        yd3.p r4 = r3.i();
        if (r4 == null) goto L33;
        yd3.m r5 = r4.l();
        if (r5 == null) goto L34;
        List<Promotion> r6 = r5.h();
        if (r6 == null) goto L35;
        List<Promotion> r7 = r6;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L26;
        PromotionProductStruct r9 = ((Promotion) r8.next()).getPromotionInfo();
        if (r9 == null) goto L23;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L23;
        String r11 = r10.getProductId();
    L24:
        r2.add(r11);
    L23:
        r11 = null;
        goto L24
    L26:
        return "{0:" + ((String) CollectionsKt.getOrNull(r2, 0)) + ",1:" + ((String) CollectionsKt.getOrNull(r2, 1)) + ",2:" + ((String) CollectionsKt.getOrNull(r2, 2)) + '}';
    L35:
        return null;
    L34:
        return null;
    L33:
        return null;
    L32:
        return null;
    L30:
        return null;
    }

    public static final void a(com.bytedance.android.ec.core.event.a r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$appendEntranceInfoParams");
        if (r5 == null) goto L21;
        JSONObject r6 = com.bytedance.android.ec.core.utils.z1.g(r5);
        if (r6 == null) goto L22;
        Iterator<String> r0 = r6.keys();
    L17:
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L8:
        if (r0.hasNext() == false) goto L23;
        String r1 = r0.next();     // Catch: Exception -> L14
        if (r1 == null) goto L13;
        String r2 = r1;     // Catch: Exception -> L14
        String r3 = r6.optString(r2);     // Catch: Exception -> L14
        com.bytedance.android.ec.core.event.a.b.a.getClass();     // Catch: Exception -> L14
        r4.appendParam(r2, r3, com.bytedance.android.ec.core.event.a.b.a.a);     // Catch: Exception -> L14
        goto L17
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L14
    L23:
        return;
    L22:
        return;
    }
}

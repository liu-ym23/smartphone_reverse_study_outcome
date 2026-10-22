package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static Pair<String, String> a;

    static {
    }

    public static boolean a(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        String r3 = r2.getDiffTag();
        if (r3 != null) goto L5;
    L10:
        return false;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        return true;
    L7:
        r4 = false;
        goto L8
    }

    public static void b(SkuParams r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "skuParams");
        Intrinsics.checkNotNullParameter(r7, "dataString");
        Map r0 = SkuPerformanceOpt.b();
        if (r0 == null) goto L5;
        Object r1 = r0.get("iesec_enable_schema_diff_report");
    L7:
        if (Intrinsics.areEqual(r1, 1) == false) goto L40;
        String r8 = r6.getDiffTag();
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L42;
        Pair<String, String> r3 = a;
        if (r3 == null) goto L21;
        String r4 = (String) r3.getFirst();
    L23:
        if (Intrinsics.areEqual(r4, r8) == true) goto L25;
        a = TuplesKt.to(r8, r7);
        return;
    L25:
        if (ECAppInfoService.e.getCurrentActivity() == null) goto L37;
        cl.d.a.getClass();
        cl.d r9 = cl.d.a.b();
        if (r9 == null) goto L29;
        r9.b();
    L29:
        int r10 = ECSdk.a;
        pi.b r11 = (pi.b) ECSdk.a(pi.b.class);
        if (r11 == null) goto L37;
        Pair[] r5 = new Pair[4];
        Pair<String, String> r12 = a;
        if (r12 == null) goto L35;
        String r13 = (String) r12.getSecond();
        if (r13 == null) goto L35;
    L36:
        r5[0] = TuplesKt.to("in_schema", r13);
        r5[1] = TuplesKt.to("out_schema", r7);
        r5[2] = TuplesKt.to("location", "ultimateBuyPanel");
        r5[3] = TuplesKt.to("business", "ultimateBuy");
        r11.monitorEvent("schema_report", k.b(MapsKt.mapOf(r5)), null, null);
    L35:
        r13 = "";
    L37:
        SkuCommonLog.c("UltimateBuyDiffTest", "diff success");
        a = null;
        return;
    L21:
        r4 = null;
        goto L23
    L42:
        return;
    L13:
        r2 = false;
        goto L14
    L40:
        return;
    L5:
        r1 = null;
        goto L7
    }
}

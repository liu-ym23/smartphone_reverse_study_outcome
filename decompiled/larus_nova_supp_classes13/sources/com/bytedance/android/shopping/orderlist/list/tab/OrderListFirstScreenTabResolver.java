package com.bytedance.android.shopping.orderlist.list.tab;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListFirstScreenTabResolver {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(Context r15, OrderListParams r16, boolean r17) {
        OrderListTabParamsCache r0 = OrderListTabParamsCache.a;
        String r1 = null;
        if (r15 == null) goto L5;
        Context r2 = r15.getApplicationContext();
    L6:
        int r4 = 0;
        r0.getClass();
        if (r2 == null) goto L60;
        String r5 = OrderListTabParamsCache.a();
        if (r5 == null) goto L60;
        String r3 = ka3.b.a(r2, r5);
        if (r3 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L60;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L52
        JSONObject r8 = new JSONObject(r3);     // Catch: Throwable -> L52
        long r9 = r8.optLong("time", 0);     // Catch: Throwable -> L52
        long r11 = ((long) ECSettingKeys.H().getCacheDuration()) * 1000;     // Catch: Throwable -> L52
        if (r9 > 0) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == true) goto L41;
        String r12 = r8.optString("tab_mode");     // Catch: Throwable -> L52
        if ((!StringsKt.isBlank(r12)) == true) goto L34;
        r12 = null;
    L34:
        if (r12 == null) goto L41;
        Object r13 = r8.opt("tab_id");     // Catch: Throwable -> L52
        if ((r13 instanceof Number) == true) goto L39;
        r13 = null;
    L39:
        Number r14 = (Number) r13;     // Catch: Throwable -> L52
        if (r14 == null) goto L41;
        Object r18 = r8.opt("biz_tab_id");     // Catch: Throwable -> L52
        if ((r18 instanceof Number) == true) goto L45;
        r18 = null;
    L45:
        Number r19 = (Number) r18;     // Catch: Throwable -> L52
        if (r19 == null) goto L48;
        Integer r20 = Integer.valueOf(r19.intValue());     // Catch: Throwable -> L52
    L49:
        a r21 = new a(r20, r14.intValue(), r12);     // Catch: Throwable -> L52
    L50:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r22) == false) goto L57;
        r22 = null;
    L57:
        a r23 = (a) r22;
        if (r23 != null) goto L61;
        r2.getSharedPreferences("js_kv_methods_20191113", 0).edit().remove(r5).apply();
    L61:
        if (r16 == null) goto L63;
        Map<String, String> r24 = r16.getSchemaParamsMap();
    L64:
        if (r24 == null) goto L70;
        String r25 = r24.get("entry_anchor_tab_id");
        if (r25 == null) goto L70;
        if ((!StringsKt.isBlank(r25)) == false) goto L70;
    L71:
        if (r24 == null) goto L77;
        String r26 = r24.get("entry_anchor_biz_tab_id");
        if (r26 == null) goto L77;
        if ((!StringsKt.isBlank(r26)) == false) goto L77;
    L78:
        if (r23 == null) goto L80;
        String r27 = r23.c;
    L82:
        if (Intrinsics.areEqual(r27, "biz_primary") == true) goto L84;
        if (r17 == true) goto L84;
    L94:
        Integer r28 = null;
    L95:
        if (r25 == null) goto L99;
        Integer r29 = StringsKt.toIntOrNull(r25);
        if (r29 == null) goto L106;
        r4 = r29.intValue();
    L106:
        if (r23 == null) goto L108;
        r1 = r23.c;
    L108:
        final a r30 = new a(r28, r4, r1);
        Lazy r31 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListFirstScreenTabResolver", new OrderListFirstScreenTabResolver$resolve$1(r30));
        return r30;
    L99:
        if (r23 == null) goto L106;
        String r32 = r23.c;
        if (r32 == null) goto L106;
        if ((!StringsKt.isBlank(r32)) != true) goto L106;
        r4 = r23.b;
    L84:
        if (r26 == null) goto L87;
        r28 = StringsKt.toIntOrNull(r26);
        if (r28 != null) goto L95;
    L87:
        if (r23 == null) goto L94;
        if (Intrinsics.areEqual(r23.c, "biz_primary") == false) goto L91;
        a r33 = r23;
    L92:
        if (r33 == null) goto L94;
        r28 = r33.a;
        goto L95
    L91:
        r33 = null;
        goto L92
    L80:
        r27 = null;
    L77:
        r26 = null;
    L70:
        r25 = null;
        goto L71
    L63:
        r24 = null;
        goto L64
    L48:
        r20 = null;
    L41:
        r21 = null;
        goto L50
    L24:
        if ((System.currentTimeMillis() - r9) >= r11) goto L27;
        r10 = false;
    L52:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L15:
        if (StringsKt.isBlank(r3) == true) goto L18;
        r6 = false;
    L60:
        r23 = null;
        goto L61
    L5:
        r2 = null;
        goto L6
    }
}

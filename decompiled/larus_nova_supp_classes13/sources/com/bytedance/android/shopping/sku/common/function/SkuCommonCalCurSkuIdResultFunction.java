package com.bytedance.android.shopping.sku.common.function;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.data.GlobalVO;
import com.bytedance.android.shopping.sku.common.data.SkuCommonSpecCalcHelper;
import com.bytedance.android.shopping.sku.common.data.f;
import com.bytedance.android.shopping.sku.common.data.g;
import com.bytedance.android.shopping.sku.common.data.h;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonCalCurSkuIdResultFunction {
    public final mh3.a a;
    public final AndroidYaTaInstance b;

    public final void b() {
        if (ECAppInfoService.e.i() == true) goto L5;
        return;
    L5:
        Map r0 = this.b.j();
        if (r0 == null) goto L8;
        Object r1 = r0.get("sku_info_map");
    L10:
        if ((r1 instanceof Map) == true) goto L12;
        r1 = null;
    L12:
        Map r2 = (Map) r1;
        if (r2 == null) goto L19;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator r4 = r2.entrySet().iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.add((String) ((Map.Entry) r4.next()).getKey());
        goto L16
    L18:
        List r5 = CollectionsKt.sorted(r3);
    L21:
        if (r5 == null) goto L46;
        Iterator r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L44;
        Object r7 = r6.next();
        Object r8 = r2.get((String) r7);
        if ((r8 instanceof Map) == true) goto L28;
        r8 = null;
    L28:
        Map r9 = (Map) r8;
        if (r9 != null) goto L31;
    L38:
        r9 = null;
    L39:
        if (r9 == null) goto L41;
        boolean r10 = true;
    L42:
        if (r10 == false) goto L24;
    L45:
        final String r11 = (String) r7;
    L47:
        Lazy r12 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonSelfCalCurSkuIdToUpdate", new SkuCommonCalCurSkuIdResultFunction$findFirstAvailableSku$1(r11));
        if (r11 != null) goto L50;
    L53:
        boolean r13 = true;
    L54:
        if (r13 == false) goto L57;
        int r14 = SkuCommonToast.a;
        SkuCommonToast.a("没有可选中的SKU");
        return;
    L57:
        List r15 = StringsKt.split$default(r11, new String[]{"_"}, false, 0, 6, null);
        c r16 = this.b.o("specs_1");
        if (r16 == null) goto L62;
        Map r17 = r16.s();
        if (r17 == null) goto L62;
        Object r18 = r17.get("specs_state");
    L64:
        if (TypeIntrinsics.isMutableMap(r18) == true) goto L66;
        r18 = null;
    L66:
        Map r19 = (Map) r18;
        Iterator r20 = r15.iterator();
        int r21 = 0;
    L68:
        if (r20.hasNext() == false) goto L83;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        String r24 = (String) r22;
        if (r19 == null) goto L75;
        Object r25 = r19.get(String.valueOf(r21));
    L77:
        if (TypeIntrinsics.isMutableMap(r25) == true) goto L79;
        r25 = null;
    L79:
        Map r26 = (Map) r25;
        if (r26 == null) goto L82;
        String r27 = (String) r26.put("selected_spec_item_id", r24);
    L82:
        r21 = r23;
        goto L68
    L75:
        r25 = null;
        goto L77
    L83:
        a r28 = a(this.b.o("specs_1"));
        Map r110 = MapsKt.mapOf(new Pair[]{TuplesKt.to("next_sku_id", r28.a), TuplesKt.to("next_specs_content", r28.b), TuplesKt.to("next_pic_spec_item_id", r28.c), TuplesKt.to("next_head_img", r28.d), TuplesKt.to("spec_items_state", r28.e)});
        Lazy r29 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonSelfCalCurSkuIdToUpdate", "doAction  nextSkuId:" + r28.a);
        this.b.k().d(e.a.a(this.b, null, "specs_1", "updateCurSkuIdForClickSpecItem", r110, "debugSelect1"));
        return;
    L62:
        r18 = null;
        goto L64
    L50:
        if (r11.length() == 0) goto L53;
        r13 = false;
        goto L54
    L41:
        r10 = false;
        goto L42
    L31:
        if (Intrinsics.areEqual(r9.get("can_select"), Boolean.TRUE) == true) goto L33;
    L35:
        boolean r30 = false;
    L36:
        if (r30 == false) goto L38;
    L33:
        if (Intrinsics.areEqual(r9.get("sku_status"), "0") == false) goto L35;
        r30 = true;
        goto L36
    L44:
        r7 = null;
        goto L45
    L46:
        r11 = null;
        goto L47
    L19:
        r5 = null;
        goto L21
    L8:
        r1 = null;
        goto L10
    }

    public final a a(c r19) {
        int r0 = g.a;
        if (r19 == null) goto L6;
        Map r1 = r19.s();
        if (r1 == null) goto L6;
    L7:
        final h r3 = g.a(r1);
        int r2 = f.a;
        mh3.a r4 = this.a;
        AndroidYaTaInstance r5 = this.b;
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        int r7 = t0.a;     // Catch: Throwable -> L10
        Gson r8 = t0.a.a;     // Catch: Throwable -> L10
        int r9 = k.a;     // Catch: Throwable -> L10
        Object r10 = Result.constructor-impl(((GlobalVO) r8.fromJson(k.b(r5.j()).toString(), GlobalVO.class)).getSkuInfoMap());     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r10) == false) goto L30;
        if (r4 == null) goto L24;
        com.bytedance.android.shopping.sku.common.monitor.error.a r11 = r4.c;
        if (r11 == null) goto L24;
        SkuErrorMonitorType r12 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r13 = Result.exceptionOrNull-impl(r10);
        if (r13 == null) goto L21;
        String r14 = r13.getMessage();
        if (r14 == null) goto L21;
    L22:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r15 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r11.a(r12, r14, null);
    L21:
        r14 = "";
    L24:
        if (ECAppInfoService.e.i() == false) goto L30;
        Throwable r16 = Result.exceptionOrNull-impl(r10);
        if (r16 == null) goto L28;
        throw r16;
    L28:
        throw new Exception("getSkuInfoMap数据解析失败");
    L30:
        if (Result.isFailure-impl(r10) == false) goto L32;
        r10 = null;
    L32:
        Map r17 = (Map) r10;
        if (r17 != null) goto L35;
        r17 = MapsKt.emptyMap();
    L35:
        int r18 = f.a;
        AndroidYaTaInstance r20 = this.b;
        Intrinsics.checkNotNullParameter(r20, "yataInstance");
        Object r21 = r20.i("default_spec_item_status");
        if ((r21 instanceof Map) == true) goto L38;
        r21 = null;
    L38:
        Map r22 = (Map) r21;
        if (r22 == null) goto L41;
        Object r23 = r22.get("spec_item_can_select");
    L43:
        if ((r23 instanceof Boolean) == true) goto L45;
        r23 = null;
    L45:
        Boolean r24 = (Boolean) r23;
        if (r24 == null) goto L48;
        boolean r25 = r24.booleanValue();
    L50:
        if (r22 == null) goto L52;
        Object r26 = r22.get("spec_item_status");
    L54:
        if ((r26 instanceof String) == true) goto L56;
        r26 = null;
    L56:
        String r27 = (String) r26;
        if (r27 != null) goto L59;
        r27 = "0";
    L59:
        com.bytedance.android.shopping.sku.common.data.c r110 = new com.bytedance.android.shopping.sku.common.data.c(r25, r27);
        Object r28 = this.b.i("default_cover");
        if ((r28 instanceof String) == true) goto L62;
        r28 = null;
    L62:
        String r29 = (String) r28;
        Map<String, com.bytedance.android.shopping.sku.common.data.a> r30 = new SkuCommonSpecCalcHelper(r17, r3, r110).d();
        if (r19 == null) goto L70;
        p r31 = r19.b.b;
        if (r31 == null) goto L70;
        Object r32 = q.b(r31, Reflection.getOrCreateKotlinClass(Map.class), "spec_items_state");
        if ((r32 instanceof Map) == true) goto L69;
        r32 = null;
    L69:
        Map r33 = (Map) r32;
    L71:
        LinkedHashMap r34 = new LinkedHashMap();
        if (r33 == null) goto L95;
        Iterator r35 = r33.entrySet().iterator();
    L75:
        if (r35.hasNext() == false) goto L95;
        Map.Entry r111 = (Map.Entry) r35.next();
        LinkedHashMap r112 = (LinkedHashMap) r30;
        com.bytedance.android.shopping.sku.common.data.a r113 = (com.bytedance.android.shopping.sku.common.data.a) r112.get(r111.getKey());
        if (r113 == null) goto L79;
        boolean r114 = r113.a;
    L80:
        com.bytedance.android.shopping.sku.common.data.a r36 = (com.bytedance.android.shopping.sku.common.data.a) r112.get(r111.getKey());
        if (r36 == null) goto L84;
        String r37 = r36.b;
        if (r37 == null) goto L84;
    L85:
        Object r115 = r111.getValue();
        if ((r115 instanceof Map) == true) goto L88;
        r115 = null;
    L88:
        Map r116 = (Map) r115;
        if (r116 == null) goto L93;
        Map r38 = MapsKt.toMutableMap(r116);
        if (r38 == null) goto L93;
        r38.put("spec_item_can_select", Boolean.valueOf(r114));
        r38.put("spec_item_status", r37);
    L94:
        r34.put(r111.getKey(), r38);
    L93:
        r38 = null;
    L84:
        r37 = "0";
        goto L85
    L79:
        r114 = true;
    L95:
        Lazy r39 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonSelfCalCurSkuIdToUpdate", new SkuCommonCalCurSkuIdResultFunction$calcResult$2(r3));
        Object r40 = this.b.i("layout_optimize");
        if ((r40 instanceof Integer) == true) goto L98;
        r40 = null;
    L98:
        Integer r41 = (Integer) r40;
        if (r41 == null) goto L101;
        int r42 = r41.intValue();
    L102:
        if (r42 <= 0) goto L104;
        String r43 = (String) r3.c.getValue();
    L105:
        String r117 = r43;
        String r118 = (String) r3.a.getValue();
        String r44 = (String) r3.e.getValue();
        if (r44 != null) goto L108;
    L111:
        boolean r45 = true;
    L113:
        if ((!r45) == false) goto L115;
        String r46 = r44;
    L116:
        if (r46 == null) goto L119;
        r29 = r46;
    L119:
        if (r29 != null) goto L121;
        String r119 = "";
    L123:
        return new a(r118, r117, (String) r3.d.getValue(), r119, r34);
    L121:
        r119 = r29;
        goto L123
    L115:
        r46 = null;
        goto L116
    L108:
        if (StringsKt.isBlank(r44) == true) goto L111;
        r45 = false;
        goto L113
    L104:
        r43 = (String) r3.b.getValue();
        goto L105
    L101:
        r42 = 0;
    L70:
        r33 = null;
        goto L71
    L52:
        r26 = null;
        goto L54
    L48:
        r25 = false;
        goto L50
    L41:
        r23 = null;
    L10:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L6:
        r1 = MapsKt.emptyMap();
        goto L7
    }

    public SkuCommonCalCurSkuIdResultFunction(mh3.a r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "yataInstance");
        this.a = r2;
        this.b = r3;
    }
}

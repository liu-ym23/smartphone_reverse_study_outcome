package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k93.g;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallMitaClickDataReportKt {
    public static final void a(DataResolver r20, g r21, final String r22, String r23) {
        Intrinsics.checkNotNullParameter(r20, "dataResolver");
        Intrinsics.checkNotNullParameter(r21, "reportAbility");
        Intrinsics.checkNotNullParameter(r22, "cardId");
        Intrinsics.checkNotNullParameter(r23, "clickArea");
        Function1<ECHybridListItemVO, Boolean> r4 = new MallMitaClickDataReportKt$reportMitaClickData$item$1(r22);
        Intrinsics.checkNotNullParameter(r4, "condition");
        ArrayList r2 = r20.i;
        if (r2 == null) goto L12;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r6 = r3.next();
        if (((Boolean) r4.invoke((ECHybridListItemVO) r6)).booleanValue() == false) goto L6;
    L11:
        ECHybridListItemVO r7 = (ECHybridListItemVO) r6;
    L13:
        if (r7 != null) goto L15;
        return;
    L15:
        int r5 = r20.k40(r7);
        if (r5 >= 0) goto L18;
        return;
    L18:
        int r8 = r20.Qc(r5);
        int r0 = r20.E90(r5);
        if (r8 < 0) goto L48;
        if (r0 < 0) goto L56;
        n r9 = r7.o;
        if (r9 != null) goto L25;
        return;
    L25:
        List r10 = r9.e;
        if (r10 == null) goto L55;
        Iterator r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L57;
        com.bytedance.android.ec.hybrid.list.entity.c r14 = (com.bytedance.android.ec.hybrid.list.entity.c) r11.next();
        String r15 = r14.a;
        if (r15 == null) goto L47;
        HashMap r12 = r9.b;
        if (r12 == null) goto L37;
        Map r13 = MapsKt.toMutableMap(r12);
        if (r13 == null) goto L37;
    L38:
        Map r16 = r13;
        Map r17 = r14.b;
        if (r17 == null) goto L41;
        r16.putAll(r17);
    L41:
        r21.a(new f(r15, r14.c, r16, r8, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", r23), TuplesKt.to("section", String.valueOf(r0)), TuplesKt.to("section_index", String.valueOf(r0))})));
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("eventName", r15), TuplesKt.to("params", r16)});
        Map r18 = r14.d;
        if (r18 == null) goto L46;
        Object r19 = r18.get("btm");
        if (r19 == null) goto L46;
        r1.put("btm", r19);
    L46:
        Unit r24 = Unit.INSTANCE;
        g.a.a(r21, r1, null, null, 14);
    L37:
        r13 = new LinkedHashMap();
    L47:
        r0 = r0;
        goto L29
    L57:
        return;
    L55:
        return;
    L56:
        return;
    L48:
        return;
    L10:
        r6 = null;
        goto L11
    L12:
        r7 = null;
        goto L13
    }
}

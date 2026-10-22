package com.bytedance.android.shopping.sku.common.data;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonSpecCalcHelper {
    public final List<b> a;
    public final Map<String, Sku> b;
    public final h c;
    public final c d;

    public final Map<String, a> d() {
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((ArrayList) this.a).iterator();
    L4:
        if (r2.hasNext() == false) goto L67;
        b r3 = (b) r2.next();
        Iterator<T> r5 = r3.a.iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        final String r6 = (String) r5.next();
        Lazy r7 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", SkuCommonSpecCalcHelper$calcSpecItemState$1.INSTANCE);
        SkuCommonLog.a("SkuYataSpecCalcHelper", new SkuCommonSpecCalcHelper$calcSpecItemState$2(this, r6));
        Map<String, Sku> r8 = this.b;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<Map.Entry<String, Sku>> r10 = r8.entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L31;
        Map.Entry<String, Sku> r11 = r10.next();
        String r12 = r11.getKey();
        if (StringsKt.contains$default(r12, r6, false, 2, null) == false) goto L28;
        List<String> r15 = r3.c;
        if ((r15 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r13 = r15.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        if ((!StringsKt.contains$default(r12, (String) r13.next(), false, 2, null)) == false) goto L21;
        boolean r14 = true;
    L26:
        if (r14 == true) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == false) goto L10;
        r9.put(r11.getKey(), r11.getValue());
    L25:
        r14 = false;
        goto L26
    L17:
        if (r15.isEmpty() == false) goto L19;
    L28:
        r16 = false;
        goto L29
    L31:
        Lazy r17 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", SkuCommonSpecCalcHelper$calcSpecItemState$3.INSTANCE);
        Iterator r18 = r9.entrySet().iterator();
    L33:
        if (r18.hasNext() == false) goto L35;
        Map.Entry r19 = (Map.Entry) r18.next();
        final String r110 = (String) r19.getKey();
        final Sku r20 = (Sku) r19.getValue();
        Lazy r111 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", new SkuCommonSpecCalcHelper$calcSpecItemState$$inlined$forEach$lambda$1(r110, r20, this));
        goto L33
    L35:
        Iterator r21 = r9.entrySet().iterator();
    L37:
        if (r21.hasNext() == false) goto L42;
        if (((Sku) ((Map.Entry) r21.next()).getValue()).getCanSelect() == false) goto L37;
        final boolean r22 = true;
    L46:
        if (r9.isEmpty() == false) goto L48;
        final String r23 = this.d.b;
    L66:
        Lazy r24 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", new SkuCommonSpecCalcHelper$calcSpecItemState$5(this, r6, r22, r23));
        SkuCommonLog.a("SkuYataSpecCalcHelper", SkuCommonSpecCalcHelper$calcSpecItemState$6.INSTANCE);
        r1.put(r6, new a(r22, r23));
        goto L7
    L48:
        Collection r25 = r9.values();
        if ((r25 instanceof Collection) == true) goto L51;
    L53:
        Iterator r26 = r25.iterator();
    L55:
        if (r26.hasNext() == false) goto L59;
        if (Intrinsics.areEqual(((Sku) r26.next()).getSkuStatus(), ((Sku) CollectionsKt.first(r25)).getSkuStatus()) == true) goto L55;
        boolean r112 = false;
    L60:
        if (r112 == false) goto L65;
        Sku r27 = (Sku) CollectionsKt.firstOrNull(r25);
        if (r27 == null) goto L65;
        r23 = r27.getSkuStatus();
        if (r23 != null) goto L66;
    L65:
        r23 = "0";
    L59:
        r112 = true;
        goto L60
    L51:
        if (r25.isEmpty() == false) goto L53;
    L42:
        if (r9.isEmpty() == false) goto L44;
        r22 = this.d.a;
        goto L46
    L44:
        r22 = false;
        goto L46
    L67:
        Iterator r4 = r1.entrySet().iterator();
    L69:
        if (r4.hasNext() == false) goto L71;
        Map.Entry r28 = (Map.Entry) r4.next();
        final String r29 = (String) r28.getKey();
        final a r30 = (a) r28.getValue();
        Lazy r31 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", new SkuCommonSpecCalcHelper$calcSpecItemCanSelectMap$$inlined$forEach$lambda$1(r29, r30, this));
        goto L69
    L71:
        return r1;
    }

    public static final String b(SkuCommonSpecCalcHelper r7, String r8) {
        Iterator r9 = ((ArrayList) r7.a).iterator();
    L4:
        if (r9.hasNext() == false) goto L10;
        Iterator<Map.Entry<String, String>> r0 = ((b) r9.next()).b.entrySet().iterator();
        String r1 = r8;
    L7:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, String> r10 = r0.next();
        r1 = StringsKt.replace$default(r1, r10.getKey(), r10.getValue(), false, 4, null);
        goto L7
    L9:
        r8 = r1;
        goto L4
    L10:
        return r8;
    }

    public static final String c(SkuCommonSpecCalcHelper r2, String r3) {
        Iterator r4 = ((ArrayList) r2.a).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        b r0 = (b) r4.next();
        if (r0.b.containsKey(r3) == false) goto L4;
        String r5 = r0.b.get(r3);
        if (r5 == null) goto L9;
        return r5;
    L9:
        return "";
    }

    public SkuCommonSpecCalcHelper(Map<String, Sku> r8, h r9, c r10) {
        Intrinsics.checkNotNullParameter(r8, "skuInfoMap");
        Intrinsics.checkNotNullParameter(r9, "fieldVO");
        Intrinsics.checkNotNullParameter(r10, "defaultSpecItemStatus");
        this.b = r8;
        this.c = r9;
        this.d = r10;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r9.g().iterator();
    L4:
        if (r12.hasNext() == false) goto L24;
        Spec r13 = (Spec) r12.next();
        List<SpecItem> r0 = r13.getSpecItemList();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.add(((SpecItem) r2.next()).getSpecItemId());
        goto L7
    L9:
        List<SpecItem> r3 = r13.getSpecItemList();
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        SpecItem r6 = (SpecItem) r5.next();
        Pair r7 = TuplesKt.to(r6.getSpecItemId(), r6.getName());
        r4.put(r7.getFirst(), r7.getSecond());
        goto L11
    L13:
        Map<String, SpecState> r14 = this.c.h();
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<Map.Entry<String, SpecState>> r16 = r14.entrySet().iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        Map.Entry<String, SpecState> r17 = r16.next();
        if ((!Intrinsics.areEqual(r17.getKey(), r13.getSpecIndex())) == false) goto L15;
        r15.put(r17.getKey(), r17.getValue());
        goto L15
    L19:
        ArrayList r18 = new ArrayList(r15.size());
        Iterator r19 = r15.entrySet().iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        r18.add(((SpecState) ((Map.Entry) r19.next()).getValue()).getSelectedSpecItemId());
        goto L21
    L23:
        r11.add(new b(r1, r4, r18));
        goto L4
    L24:
        this.a = r11;
        Lazy r20 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", AnonymousClass1.INSTANCE);
        Iterator<Map.Entry<String, Sku>> r21 = this.b.entrySet().iterator();
    L26:
        if (r21.hasNext() == false) goto L28;
        Map.Entry<String, Sku> r110 = r21.next();
        final String r22 = r110.getKey();
        final Sku r111 = r110.getValue();
        Lazy r23 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSpecCalcHelper", new SkuCommonSpecCalcHelper$$special$$inlined$forEach$lambda$1(r22, r111, this));
        goto L26
    }

    public static final String a(SkuCommonSpecCalcHelper r2, String r3, int r4) {
        r2.getClass();
        if (r4 <= 60) goto L5;
        r4 = 60;
    L5:
        int r5 = r4 - r3.length();
        StringBuilder r6 = new StringBuilder();
        r6.append(r3);
        StringBuilder r7 = new StringBuilder();
        int r0 = 1;
        if (1 > r5) goto L10;
    L7:
        r7.append(" ");
        if (r0 == r5) goto L10;
        r0 = r0 + 1;
    L10:
        Unit r8 = Unit.INSTANCE;
        r6.append(r7.toString());
        return r6.toString();
    }
}

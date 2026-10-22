package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(ECStoreParam r12, ECStoreTabAreaVO r13) {
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        Object r1 = null;
        int r2 = -1;
        int r4 = 0;
        if (r13 == null) goto L57;
        List<uj3.j> r5 = r13.b;
        if (r5 == null) goto L57;
        if (r12.isPreview() == false) goto L16;
        Iterator<uj3.j> r6 = r5.iterator();
        int r7 = 0;
    L11:
        if (r6.hasNext() == false) goto L55;
        if (r6.next().f == true) goto L56;
        r7 = r7 + 1;
    L56:
        int r8 = RangesKt.coerceAtLeast(r7, 0);
    L58:
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        if (r13 == null) goto L115;
        List<uj3.j> r14 = r13.b;
        if (r14 == null) goto L115;
        int r0 = r14.size();
        if (r8 < 0) goto L67;
        if (r0 <= r8) goto L67;
        boolean r3 = true;
    L68:
        if (r3 == true) goto L71;
        r14 = null;
    L71:
        if (r14 == null) goto L115;
        Object r15 = ListProtector.get(r14, r8);
        List<uj3.j> r9 = ((uj3.j) r15).b;
        if (r9 != null) goto L76;
    L79:
        boolean r10 = true;
    L81:
        if ((!r10) == false) goto L83;
        r1 = r15;
    L83:
        uj3.j r11 = (uj3.j) r1;
        if (r11 == null) goto L115;
        List<uj3.j> r16 = r11.b;
        if (r16 == null) goto L115;
        if (r12.isPreview() == false) goto L97;
        Iterator<uj3.j> r17 = r16.iterator();
        int r18 = 0;
    L92:
        if (r17.hasNext() == false) goto L113;
        if (r17.next().f == true) goto L95;
        r18 = r18 + 1;
    L95:
        r2 = r18;
    L113:
        r4 = RangesKt.coerceAtLeast(r2, 0);
        goto L115
    L97:
        Integer r19 = r11.c;
        if (r19 != null) goto L100;
        r19 = r12.getTabId();
    L100:
        Iterator<uj3.j> r110 = r16.iterator();
        r18 = 0;
    L102:
        if (r110.hasNext() == false) goto L113;
        int r20 = r110.next().d;
        if (r19 != null) goto L107;
    L109:
        boolean r21 = false;
    L110:
        if (r21 == true) goto L95;
        r18 = r18 + 1;
        goto L102
    L107:
        if (r20 != r19.intValue()) goto L109;
        r21 = true;
        goto L110
    L76:
        if (r9.isEmpty() == true) goto L79;
        r10 = false;
    L67:
        r3 = false;
    L115:
        return new Pair(Integer.valueOf(r8), Integer.valueOf(r4));
    L55:
        r7 = -1;
        goto L56
    L16:
        Integer r22 = r13.c;
        if (r22 != null) goto L19;
        r22 = r12.getTabId();
    L19:
        Iterator<uj3.j> r23 = r5.iterator();
        int r24 = 0;
    L21:
        if (r23.hasNext() == false) goto L55;
        uj3.j r25 = r23.next();
        int r26 = r25.d;
        if (r22 != null) goto L26;
    L27:
        List<uj3.j> r27 = r25.b;
        if (r27 != null) goto L30;
    L47:
        int r28 = -1;
    L48:
        if (r28 >= 0) goto L51;
        boolean r29 = false;
    L52:
        if (r29 == true) goto L53;
        r24 = r24 + 1;
        goto L21
    L53:
        r7 = r24;
    L51:
        r29 = true;
        goto L52
    L30:
        if ((!r27.isEmpty()) == true) goto L33;
        r27 = null;
    L33:
        if (r27 == null) goto L47;
        Iterator<uj3.j> r30 = r27.iterator();
        r28 = 0;
    L36:
        if (r30.hasNext() == false) goto L47;
        int r111 = r30.next().d;
        if (r22 != null) goto L41;
    L43:
        boolean r112 = false;
    L44:
        if (r112 == true) goto L48;
        r28 = r28 + 1;
        goto L36
    L41:
        if (r111 != r22.intValue()) goto L43;
        r112 = true;
        goto L44
    L26:
        if (r26 == r22.intValue()) goto L51;
    L57:
        r8 = 0;
        goto L58
    }

    public static uj3.j b(ECStoreParam r4, ECStoreTabAreaVO r5) {
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        if (r5 == null) goto L6;
        List<uj3.j> r0 = r5.b;
        if (r0 == null) goto L6;
    L7:
        Pair r6 = a(r4, r5);
        int r7 = r0.size();
        int r1 = ((Number) r6.getFirst()).intValue();
        uj3.j r2 = null;
        if (r1 < 0) goto L12;
        if (r7 <= r1) goto L12;
        uj3.j r8 = (uj3.j) ListProtector.get(r0, ((Number) r6.getFirst()).intValue());
    L13:
        if (r8 == null) goto L22;
        List<uj3.j> r3 = r8.b;
        if (r3 != null) goto L17;
        r3 = CollectionsKt.emptyList();
    L17:
        int r9 = r3.size();
        int r10 = ((Number) r6.getSecond()).intValue();
        if (r10 < 0) goto L22;
        if (r9 <= r10) goto L22;
        r2 = (uj3.j) ListProtector.get(r3, ((Number) r6.getSecond()).intValue());
    L22:
        if (r2 != null) goto L25;
        return r8;
    L25:
        return r2;
    L12:
        r8 = null;
    L6:
        r0 = CollectionsKt.emptyList();
        goto L7
    }

    public static boolean c(List r3, Pair r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "tabList");
        Intrinsics.checkNotNullParameter(r4, "tabLocation");
        Intrinsics.checkNotNullParameter(r5, "condition");
        if (r3.isEmpty() == false) goto L5;
        return false;
    L5:
        int r0 = r3.size();
        int r2 = ((Number) r4.getFirst()).intValue();
        if (r2 < 0) goto L19;
        if (r0 <= r2) goto L19;
        uj3.j r6 = (uj3.j) ListProtector.get(r3, ((Number) r4.getFirst()).intValue());
        List<uj3.j> r1 = r6.b;
        if (r1 == null) goto L18;
        int r7 = r1.size();
        int r8 = ((Number) r4.getSecond()).intValue();
        if (r8 < 0) goto L21;
        if (r7 > r8) goto L16;
        return false;
    L16:
        return ((Boolean) r5.invoke(ListProtector.get(r1, ((Number) r4.getSecond()).intValue()))).booleanValue();
    L21:
        return false;
    L18:
        return ((Boolean) r5.invoke(r6)).booleanValue();
    L19:
        return false;
    }
}

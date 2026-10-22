package com.bytedance.bdnavigationsdk.navigation;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y {
    public final Set<String> a;

    public static final class a {
    }

    static {
    }

    public y() {
        this.a = new LinkedHashSet();
    }

    public static Integer b(String r3) {
        String r4 = StringsKt.trim(r3).toString();
        boolean r1 = true;
        if (r4.length() > 1) goto L5;
    L15:
        return null;
    L5:
        if (Character.toLowerCase(StringsKt.first(r4)) != 'v') goto L15;
        Integer r5 = StringsKt.toIntOrNull(StringsKt.drop(r4, 1));
        if (r5 == null) goto L15;
        if (r5.intValue() > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        return r5;
    }

    public final v a(int r18, com.bytedance.bdnavigationsdk.network.route.q r19, float r20) {
        Intrinsics.checkNotNullParameter(r19, "step");
        List<com.bytedance.bdnavigationsdk.network.route.r> r1 = r19.f;
        if (r1 != null) goto L5;
        return null;
    L5:
        Iterator<T> r2 = r1.iterator();
        int r5 = 0;
    L7:
        if (r2.hasNext() == false) goto L78;
        int r6 = r5 + 1;
        com.bytedance.bdnavigationsdk.network.route.r r7 = (com.bytedance.bdnavigationsdk.network.route.r) r2.next();
        String r8 = r18 + ":" + r5;
        if (this.a.contains(r8) == true) goto L77;
        String r9 = r7.c;
        boolean r10 = true;
        if (r9 == null) goto L32;
        String r11 = StringsKt.trim(r9).toString();
        if (r11 == null) goto L32;
        if (r11.length() <= 0) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L32;
        Integer r13 = b(r11);
        if (r13 == null) goto L31;
        int r14 = r13.intValue();
        Integer r15 = b(LocationInfoConst.LIBRA_PARAM_V1);
        if (r15 == null) goto L31;
        if (r14 <= r15.intValue()) goto L32;
    L31:
        boolean r16 = false;
    L33:
        if (r16 == false) goto L77;
        com.bytedance.bdnavigationsdk.network.route.s r17 = r7.a;
        if (r17 != null) goto L39;
    L43:
        boolean r21 = false;
    L44:
        if (r21 == false) goto L77;
        String r110 = r7.b;
        if (r110 == null) goto L77;
        int r22 = com.bytedance.bdnavigationsdk.utils.f.a;
        int r23 = (int) r20;
        int r24 = r23 / 1000;
        int r111 = r23 - (r24 * 1000);
        int r112 = r111 / 100;
        int r113 = r112 * 100;
        int r114 = (r111 - r113) / 10;
        int r4 = r23 % 1000;
        if (r24 <= 0) goto L59;
        float r25 = com.bytedance.bdnavigationsdk.utils.b.b(r23 / 1000.0f, 1);
        int r26 = (int) r25;
        if (r25 != r26) goto L53;
        boolean r27 = true;
    L54:
        if (r27 == false) goto L56;
        String r28 = String.valueOf(r26);
    L57:
        String r29 = r28 + "公里";
    L65:
        String r30 = StringsKt.replace$default(r110, "${remain_distance}", r29, false, 4, null);
        if (r30 == null) goto L77;
        if (r30.length() > 0) goto L71;
        r10 = false;
    L71:
        if (r10 == true) goto L74;
        r30 = null;
    L74:
        if (r30 == null) goto L77;
        this.a.add(r8);
        return new v(r30);
    L56:
        r28 = String.valueOf(r25);
        goto L57
    L53:
        r27 = false;
        goto L54
    L59:
        if (r112 <= 0) goto L62;
        r29 = (r113 + (r114 * 10)) + "米";
        goto L65
    L62:
        if (r114 <= 0) goto L64;
        r29 = (r114 * 10) + "米";
        goto L65
    L64:
        r29 = r4 + "米";
        goto L65
    L39:
        if (r17.a <= r20) goto L43;
        if (r20 < r17.b) goto L43;
        r21 = true;
        goto L44
    L18:
        r12 = false;
    L32:
        r16 = true;
    L77:
        r5 = r6;
        goto L7
    L78:
        return null;
    }
}

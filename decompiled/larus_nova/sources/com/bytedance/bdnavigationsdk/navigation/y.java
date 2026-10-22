package com.bytedance.bdnavigationsdk.navigation;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f200116a;

    public static final class a {
    }

    static {
    }

    public y() {
        this.f200116a = new LinkedHashSet();
    }

    public static Integer b(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        boolean r102 = true;
        if (r101.length() > 1) goto L5;
    L15:
        return null;
    L5:
        if (Character.toLowerCase(StringsKt.first(r101)) != 'v') goto L15;
        Integer r103 = StringsKt.toIntOrNull(StringsKt.drop(r101, 1));
        if (r103 == null) goto L15;
        if (r103.intValue() > 0) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L15;
        return r103;
    }

    public final v a(int r110, com.bytedance.bdnavigationsdk.network.route.q r111, float r210) {
        Intrinsics.checkNotNullParameter(r111, "step");
        List<com.bytedance.bdnavigationsdk.network.route.r> r100 = r111.f200269f;
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L78;
        int r103 = r102 + 1;
        com.bytedance.bdnavigationsdk.network.route.r r104 = (com.bytedance.bdnavigationsdk.network.route.r) r101.next();
        String r105 = r110 + ":" + r102;
        if (this.f200116a.contains(r105) == true) goto L77;
        String r106 = r104.f200275c;
        boolean r112 = true;
        if (r106 == null) goto L32;
        String r107 = StringsKt.trim(r106).toString();
        if (r107 == null) goto L32;
        if (r107.length() <= 0) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == true) goto L22;
        r107 = null;
    L22:
        if (r107 == null) goto L32;
        Integer r108 = b(r107);
        if (r108 == null) goto L31;
        int r109 = r108.intValue();
        Integer r114 = b("v1");
        if (r114 == null) goto L31;
        if (r109 <= r114.intValue()) goto L32;
    L31:
        boolean r115 = false;
    L33:
        if (r115 == false) goto L77;
        com.bytedance.bdnavigationsdk.network.route.s r116 = r104.f200273a;
        if (r116 != null) goto L39;
    L43:
        boolean r117 = false;
    L44:
        if (r117 == false) goto L77;
        String r118 = r104.f200274b;
        if (r118 == null) goto L77;
        int r119 = com.bytedance.bdnavigationsdk.utils.f.f200379a;
        int r120 = (int) r210;
        int r121 = r120 / 1000;
        int r122 = r120 - (r121 * 1000);
        int r123 = r122 / 100;
        int r124 = r123 * 100;
        int r125 = (r122 - r124) / 10;
        int r126 = r120 % 1000;
        if (r121 <= 0) goto L59;
        float r127 = com.bytedance.bdnavigationsdk.utils.b.b(r120 / 1000.0f, 1);
        int r128 = (int) r127;
        if (r127 != r128) goto L53;
        boolean r129 = true;
    L54:
        if (r129 == false) goto L56;
        String r130 = String.valueOf(r128);
    L57:
        String r131 = r130 + "公里";
    L65:
        String r132 = StringsKt.replace$default(r118, "${remain_distance}", r131, false, 4, null);
        if (r132 == null) goto L77;
        if (r132.length() > 0) goto L71;
        r112 = false;
    L71:
        if (r112 == true) goto L74;
        r132 = null;
    L74:
        if (r132 == null) goto L77;
        this.f200116a.add(r105);
        return new v(r132);
    L56:
        r130 = String.valueOf(r127);
        goto L57
    L53:
        r129 = false;
        goto L54
    L59:
        if (r123 <= 0) goto L62;
        r131 = (r124 + (r125 * 10)) + "米";
        goto L65
    L62:
        if (r125 <= 0) goto L64;
        r131 = (r125 * 10) + "米";
        goto L65
    L64:
        r131 = r126 + "米";
        goto L65
    L39:
        if (r116.f200278a <= r210) goto L43;
        if (r210 < r116.f200279b) goto L43;
        r117 = true;
        goto L44
    L18:
        r113 = false;
    L32:
        r115 = true;
    L77:
        r102 = r103;
        goto L7
    L78:
        return null;
    }
}

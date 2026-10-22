package com.bytedance.locallife.live.util;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class y {
    public static final Integer b(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.get(r101);
        if ((r102 instanceof Integer) == false) goto L6;
        return (Integer) r102;
    L6:
        if ((r102 instanceof Float) == false) goto L9;
        return Integer.valueOf((int) ((Number) r102).floatValue());
    L9:
        if ((r102 instanceof Double) == true) goto L15;
        return null;
    L15:
        return Integer.valueOf((int) ((Number) r102).doubleValue());
    }

    public static final HashMap<String, Object> c(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof HashMap) == true) goto L9;
        return null;
    L9:
        return (HashMap) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final String d(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.get(r101);
        if ((r102 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r102;
    }

    public static final JsonObject e(Map<String, ? extends Object> r100, Function1<? super Map<String, Object>, Unit> r101) {
        if (r100 == null) goto L7;
        Gson r102 = LiveLifeSaaSUtil.r();
        Map r103 = MapsKt.toMutableMap(r100);
        if (r101 == null) goto L9;
        r101.invoke(r103);
    L9:
        return GsonProtectorUtils.toJsonTree(r102, r103).getAsJsonObject();
    L7:
        return null;
    }

    public static final boolean a(Map<String, ? extends Object> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r103 = r100.get(r101);
    L7:
        if ((r103 instanceof Boolean) == false) goto L11;
        return ((Boolean) r103).booleanValue();
    L11:
        if ((r103 instanceof String) == false) goto L24;
        String r104 = (String) r103;
        if (StringsKt.equals(r104, "true", true) == false) goto L15;
    L23:
        return true;
    L15:
        if (StringsKt.equals(r104, BdpAppEventConstant.YES, true) == true) goto L23;
        if (StringsKt.equals(r104, "false", true) == false) goto L20;
        return false;
    L20:
        if (StringsKt.equals(r104, BdpAppEventConstant.NO, true) == false) goto L24;
        return false;
    L24:
        return r102;
    L5:
        r103 = null;
        goto L7
    }
}

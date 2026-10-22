package com.bytedance.salamander.anniex;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b1 {
    public static final b5 a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "redirectRuleJSONObject");
        int r101 = 0;
        int r102 = com.bytedance.anniex.bd.foundation.impl.o.f(r100, "ruleType", 0);
        Object r103 = com.bytedance.anniex.bd.foundation.impl.o.n(r100, "location", 0);
        int r104 = com.bytedance.rts.foundation.v.f267594a;
        if ((r103 instanceof String) == false) goto L6;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        return new b5(r102, (String) r103, null, r100);
    L6:
        Intrinsics.checkNotNull(r103);
        if (com.bytedance.anniex.bd.foundation.impl.o.q(r103) == false) goto L13;
        ArrayList r105 = com.bytedance.rts.foundation.j.k(new b5[0]);
        b5 r106 = a((JSONObject) r103);
        if (r106 == null) goto L12;
        com.bytedance.rts.foundation.j.j(r105, r106);
    L12:
        return new b5(r102, null, r105, r100);
    L13:
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r107 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r103 instanceof JSONArray) == false) goto L32;
        ArrayList r108 = com.bytedance.rts.foundation.j.k(new b5[0]);
        JSONArray r109 = (JSONArray) r103;
    L17:
        if (r101 >= com.bytedance.anniex.bd.foundation.impl.o.h(r109)) goto L31;
        Object r110 = r109.get(r101);
        if (r110 == null) goto L29;
        int r111 = com.bytedance.rts.foundation.v.f267594a;
        if ((r110 instanceof String) == false) goto L25;
        com.bytedance.rts.foundation.j.j(r108, new b5(r102, (String) r110, null, r100));
        goto L29
    L25:
        if (com.bytedance.anniex.bd.foundation.impl.o.q(r110) == false) goto L29;
        b5 r112 = a((JSONObject) r110);
        if (r112 == null) goto L29;
        com.bytedance.rts.foundation.j.j(r108, r112);
    L29:
        r101 = r101 + 1;
        goto L17
    L31:
        return new b5(r102, null, r108, r100);
    L32:
        return null;
    }
}

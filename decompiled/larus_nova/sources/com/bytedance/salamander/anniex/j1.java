package com.bytedance.salamander.anniex;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class j1 {
    public static final JSONObject a(String r100, JSONObject r101, Function1<? super Map<String, Object>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "category");
        LinkedHashMap r103 = new LinkedHashMap();
        LinkedHashMap r104 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r103, "errorCode", -1);
        com.bytedance.rts.foundation.m.e(r103, "errorMessage", "failed");
        if (com.bytedance.rts.foundation.j.d(com.bytedance.anniex.bd.foundation.impl.o.k(r101)) <= 50) goto L9;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("SLCustomReport", "customReport: category must not contain more than 50 keys. eventName:" + r100);
        com.bytedance.rts.foundation.m.e(r103, "errorCode", -3);
        com.bytedance.rts.foundation.m.e(r103, "errorMessage", "category must not contain more than 50 keys");
        if (r102 == null) goto L26;
        r102.invoke(r103);
        return null;
    L26:
        return null;
    L9:
        ArrayList r105 = com.bytedance.anniex.bd.foundation.impl.o.k(r101);
        int r106 = 0;
    L11:
        if (r106 >= com.bytedance.rts.foundation.j.d(r105)) goto L20;
        String r107 = (String) ListProtector.get(r105, r106);
        Object r108 = com.bytedance.anniex.bd.foundation.impl.o.m(r101, r107);
        if (r108 == null) goto L18;
        z1.f268535a.getClass();
        Intrinsics.checkNotNullParameter(r108, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        String r109 = String.valueOf(r108);
        a8 r110 = d2.f268022a;
        String r111 = r110.c("custom_category_key", r107);
        String r112 = r110.c("custom_category_value", r109);
        if (r111 == null) goto L18;
        if (r112 == null) goto L18;
        com.bytedance.rts.foundation.m.e(r104, r111, r112);
    L18:
        r106 = r106 + 1;
        goto L11
    L20:
        return com.bytedance.anniex.bd.foundation.impl.o.e(r104);
    }

    public static final JSONObject b(String r100, JSONObject r101, Function1<? super Map<String, Object>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        LinkedHashMap r103 = new LinkedHashMap();
        LinkedHashMap r104 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r103, "errorCode", -1);
        com.bytedance.rts.foundation.m.e(r103, "errorMessage", "failed");
        if (com.bytedance.rts.foundation.j.d(com.bytedance.anniex.bd.foundation.impl.o.k(r101)) <= 50) goto L9;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("SLCustomReport", "customReport: extra must not contain more than 50 keys, eventName:" + r100);
        com.bytedance.rts.foundation.m.e(r103, "errorCode", -3);
        com.bytedance.rts.foundation.m.e(r103, "errorMessage", "extra must not contain more than 50 keys");
        if (r102 == null) goto L21;
        r102.invoke(r103);
        return null;
    L21:
        return null;
    L9:
        ArrayList r105 = com.bytedance.anniex.bd.foundation.impl.o.k(r101);
        int r106 = 0;
    L11:
        if (r106 >= com.bytedance.rts.foundation.j.d(r105)) goto L17;
        String r107 = (String) ListProtector.get(r105, r106);
        Object r108 = com.bytedance.anniex.bd.foundation.impl.o.m(r101, r107);
        if (r108 == null) goto L15;
        z1.f268535a.getClass();
        Intrinsics.checkNotNullParameter(r108, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        String r109 = String.valueOf(r108);
        Intrinsics.checkNotNull(r109);
        com.bytedance.rts.foundation.m.e(r104, r107, r109);
    L15:
        r106 = r106 + 1;
        goto L11
    L17:
        return com.bytedance.anniex.bd.foundation.impl.o.e(r104);
    }

    public static final JSONObject c(String r110, JSONObject r111, Function1<? super Map<String, Object>, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "metrics");
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r100, "errorCode", -1);
        com.bytedance.rts.foundation.m.e(r100, "errorMessage", "failed");
        if (com.bytedance.rts.foundation.j.d(com.bytedance.anniex.bd.foundation.impl.o.k(r111)) <= 50) goto L8;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("SLCustomReport", "customReport: metrics must not contain more than 50 keys, eventName: " + r110);
        com.bytedance.rts.foundation.m.e(r100, "errorCode", -3);
        com.bytedance.rts.foundation.m.e(r100, "errorMessage", "metrics must not contain more than 50 keys");
        if (r112 == null) goto L7;
        r112.invoke(r100);
    L7:
        return null;
    L8:
        Intrinsics.checkNotNullParameter(r111, "jsonMap");
        ArrayList r101 = com.bytedance.anniex.bd.foundation.impl.o.k(r111);
        boolean r102 = false;
        int r103 = 0;
    L10:
        if (r103 >= com.bytedance.rts.foundation.j.d(r101)) goto L17;
        Object r104 = com.bytedance.anniex.bd.foundation.impl.o.m(r111, (String) ListProtector.get(r101, r103));
        if (r104 == null) goto L16;
        Intrinsics.checkNotNullParameter(r104, "value");
        int r113 = com.bytedance.rts.foundation.v.f267594a;
        if ((!(r104 instanceof String)) == true) goto L16;
    L18:
        if (r102 == true) goto L23;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("SLCustomReport", "customReport: metrics must be Map<string, number>, eventName: " + r110);
        com.bytedance.rts.foundation.m.e(r100, "errorCode", -3);
        com.bytedance.rts.foundation.m.e(r100, "errorMessage", "metrics must be Map<string, number>");
        if (r112 == null) goto L22;
        r112.invoke(r100);
    L22:
        return null;
    L23:
        return r111;
    L16:
        r103 = r103 + 1;
        goto L10
    L17:
        r102 = true;
        goto L18
    }
}

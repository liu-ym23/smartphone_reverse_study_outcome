package com.bytedance.salamander.anniex;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class h1 {
    public static final v2 a(v2 r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        v2 r101 = new v2();
        String r102 = r100.f268436p;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f268436p = r102;
        r101.a(r100.f268437q);
        ContainerName r103 = r100.f268422b;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f268422b = r103;
        ContainerType r104 = r100.f268428h;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f268428h = r104;
        r101.f268429i = r100.f268429i;
        r101.f268427g = r100.f268427g;
        r101.f268432l = r100.f268432l;
        String r105 = r100.f268421a;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f268421a = r105;
        String r106 = r100.f268431k;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r101.f268431k = r106;
        String r107 = r100.f268426f;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r101.f268426f = r107;
        r101.f268438r = r100.f268438r;
        String r108 = r100.f268423c;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r101.f268423c = r108;
        String r109 = r100.f268430j;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r101.f268430j = r109;
        TemplateResType r110 = r100.f268424d;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r101.f268424d = r110;
        r101.f268435o = r100.f268435o;
        ViewType r111 = r100.f268425e;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r101.f268425e = r111;
        r101.f268434n = r100.f268434n;
        r101.f268433m = r100.f268433m;
        l4 r112 = r100.f268439s;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r101.f268439s = r112;
        return r101;
    }

    public static final q5 b(JSONObject r110, String r210, Function1<? super Map<String, Object>, Unit> r211) {
        Intrinsics.checkNotNullParameter(r110, "json");
        Intrinsics.checkNotNullParameter(r210, "navigationId");
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r100, "errorCode", -1);
        com.bytedance.rts.foundation.m.e(r100, "errorMessage", "failed");
        String r101 = com.bytedance.anniex.bd.foundation.impl.o.o(r110, "eventName");
        int r102 = com.bytedance.anniex.bd.foundation.impl.o.f(r110, "level", 2);
        String r111 = com.bytedance.anniex.bd.foundation.impl.o.o(r110, "bid");
        JSONObject r112 = com.bytedance.anniex.bd.foundation.impl.o.i(r110, "category");
        JSONObject r113 = com.bytedance.anniex.bd.foundation.impl.o.i(r110, "metrics");
        JSONObject r103 = com.bytedance.anniex.bd.foundation.impl.o.i(r110, "extra");
        if (r101 != null) goto L5;
    L42:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("SLCustomReport", "jsonObjectToCustomEvent: eventName is undefined " + r210);
        com.bytedance.rts.foundation.m.e(r100, "errorCode", -3);
        com.bytedance.rts.foundation.m.e(r100, "errorMessage", "eventName must not be empty");
        if (r211 == null) goto L45;
        r211.invoke(r100);
    L45:
        return null;
    L5:
        if (Intrinsics.areEqual(r101, "") == true) goto L42;
        if (r102 >= 0) goto L9;
    L12:
        int r114 = 2;
    L13:
        if (r113 != null) goto L15;
    L17:
        if (r112 == null) goto L21;
        JSONObject r104 = j1.a(r101, r112, r211);
        if (r104 != null) goto L22;
        return null;
    L22:
        if (r103 == null) goto L26;
        JSONObject r105 = j1.b(r101, r103, r211);
        if (r105 != null) goto L27;
        return null;
    L27:
        Intrinsics.checkNotNullParameter(r101, "eventName");
        if (r111 == null) goto L30;
        Intrinsics.checkNotNullParameter(r111, "bid");
        String r106 = r111;
    L31:
        if (r104 == null) goto L33;
        Intrinsics.checkNotNullParameter(r104, "category");
        JSONObject r115 = r104;
    L34:
        if (r113 == null) goto L36;
        Intrinsics.checkNotNullParameter(r113, "metrics");
        JSONObject r116 = r113;
    L37:
        if (r105 == null) goto L39;
        Intrinsics.checkNotNullParameter(r105, "extra");
        JSONObject r117 = r105;
    L41:
        return new q5(r101, Integer.valueOf(r114), null, null, r106, r115, r116, r117);
    L39:
        r117 = null;
        goto L41
    L36:
        r116 = null;
        goto L37
    L33:
        r115 = null;
        goto L34
    L30:
        r106 = null;
        goto L31
    L26:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L22
    L15:
        if (j1.c(r101, r113, r211) != null) goto L17;
        return null;
    L9:
        if (r102 > 8) goto L12;
        r114 = r102;
        goto L13
    }
}

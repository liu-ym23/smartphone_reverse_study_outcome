package com.bytedance.salamander.anniex;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f268024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f268025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f268026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f268027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ArrayList<b5>> f268028e;

    public final z4 a(y4 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = r100.f268524b;
        JSONObject r102 = this.f268024a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        Object r103 = com.bytedance.anniex.bd.foundation.impl.o.m(r102, r101);
    L6:
        if (r103 != null) goto L9;
        int r104 = x4.f268501d;
        return new z4(null, 3, "no entry config");
    L9:
        a5 r105 = r100.f268528f;
        if (r105 == null) goto L12;
        y2 r106 = r105.f267954b;
    L14:
        if (r106 != null) goto L16;
    L25:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "getTargetInfoWithEntryKey: \n key: " + r101 + ";\n rawRules: " + r103);
        Object r107 = ((LinkedHashMap) this.f268028e).get(r101);
        if (r107 != null) goto L28;
        r107 = new ArrayList();
        com.bytedance.rts.foundation.m.e(this.f268028e, r101, r107);
    L28:
        ArrayList r108 = (ArrayList) r107;
        int r109 = 0;
        if (com.bytedance.rts.foundation.j.d(r108) != 0) goto L51;
        int r110 = com.bytedance.rts.foundation.v.f267594a;
        if ((r103 instanceof String) == false) goto L35;
        return new z4((String) r103);
    L35:
        if (com.bytedance.anniex.bd.foundation.impl.o.q(r103) == false) goto L39;
        b5 r111 = b1.a((JSONObject) r103);
        if (r111 == null) goto L51;
        com.bytedance.rts.foundation.j.j(r108, r111);
        goto L51
    L39:
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r112 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r103 instanceof JSONArray) == false) goto L51;
        JSONArray r113 = (JSONArray) r103;
        int r114 = 0;
    L43:
        if (r114 >= com.bytedance.anniex.bd.foundation.impl.o.h(r113)) goto L51;
        Object r115 = r113.get(r114);
        if (com.bytedance.anniex.bd.foundation.impl.o.q(r115) == false) goto L49;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.anniex.bd.foundation.api.BDAnnieXBasicTypeKt.SLJSONObject }");
        b5 r116 = b1.a((JSONObject) r115);
        if (r116 == null) goto L49;
        com.bytedance.rts.foundation.j.j(r108, r116);
    L49:
        r114 = r114 + 1;
    L51:
        if (r109 >= com.bytedance.rts.foundation.j.d(r108)) goto L56;
        z4 r117 = ((b5) ListProtector.get(r108, r109)).a(r100);
        if (r117 != null) goto L54;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "rule match failed");
        r109 = r109 + 1;
        goto L51
    L54:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "rule match success");
    L57:
        if (r117 == null) goto L59;
        return r117;
    L59:
        int r118 = x4.f268501d;
        return new z4(null, 4, "no match rule");
    L56:
        r117 = null;
        goto L57
    L16:
        if (com.bytedance.anniex.bd.foundation.impl.o.q(r103) == false) goto L18;
        a5 r119 = r100.f268528f;
        Intrinsics.checkNotNull(r119);
        y2 r120 = r119.f267954b;
        String r121 = com.bytedance.anniex.bd.foundation.impl.o.a((JSONObject) r103);
        r120.getClass();
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r120.f268520a = r121;
        goto L25
    L18:
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r122 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r103 instanceof JSONArray) == false) goto L24;
        a5 r123 = r100.f268528f;
        Intrinsics.checkNotNull(r123);
        y2 r124 = r123.f267954b;
        JSONArray r125 = (JSONArray) r103;
        Intrinsics.checkNotNullParameter(r125, "jsonArray");
        Intrinsics.checkNotNullParameter(r125, "jsonArray");
        String r126 = r125.toString();
        if (r126 != null) goto L23;
        r126 = SliceInitService.DEFAULT_SWITCH;
    L23:
        r124.getClass();
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r124.f268520a = r126;
        goto L25
    L24:
        a5 r127 = r100.f268528f;
        Intrinsics.checkNotNull(r127);
        y2 r128 = r127.f267954b;
        String r129 = String.valueOf(r103);
        r128.getClass();
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r128.f268520a = r129;
        goto L25
    L12:
        r106 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    public d5(JSONObject r100, JSONObject r101, String r102, long r103) {
        int r104 = com.bytedance.rts.foundation.c.f267576a;
        int r105 = com.bytedance.rts.foundation.b.f267575a;
        this.f268027d = System.currentTimeMillis();
        this.f268028e = new LinkedHashMap();
        this.f268024a = r100;
        this.f268025b = r101;
        this.f268026c = r102;
        this.f268027d = r103;
    }
}

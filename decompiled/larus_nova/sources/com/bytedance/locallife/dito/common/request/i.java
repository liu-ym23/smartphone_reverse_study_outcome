package com.bytedance.locallife.dito.common.request;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class i {
    public static final Map a(com.bytedance.locallife.dito.data.k r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("poi_detail", "scene");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("scene", "poi_detail");
        r102.put("location_permission", Integer.valueOf(r101 ? 1 : 0));
        r102.put("service_type", r100.f258213f);
        Map<String, Object> r103 = r100.f258209b;
        Map<String, Object> r104 = null;
        if (TypeIntrinsics.isMutableMap(r103) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L9;
        String r105 = new JSONObject(r103).toString();
        if (r105 == null) goto L9;
    L10:
        r102.put("params", r105);
        Map<String, Object> r106 = r100.f258210c;
        if (TypeIntrinsics.isMutableMap(r106) == false) goto L13;
        r104 = r106;
    L13:
        if (r104 == null) goto L16;
        String r107 = new JSONObject(r104).toString();
        if (r107 == null) goto L16;
    L17:
        r102.put("dito_params", r107);
        Object r108 = r100.f258209b.get("dito_retry");
        if (r108 == null) goto L20;
        r102.put("dito_retry", r108);
    L20:
        return r102;
    L16:
        r107 = new JSONObject(MapsKt.mapOf(TuplesKt.to("service_type", r100.f258213f))).toString();
    L9:
        r105 = "";
        goto L10
    }
}

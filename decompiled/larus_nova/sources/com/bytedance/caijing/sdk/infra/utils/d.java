package com.bytedance.caijing.sdk.infra.utils;

import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202786a = 0;

    static {
    }

    public static JSONObject a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));     // Catch: Exception -> L12
        Iterator r102 = r100.entrySet().iterator();     // Catch: Exception -> L12
    L5:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Exception -> L12
        Object r104 = ((Map.Entry) r103).getKey();     // Catch: Exception -> L12
        Object r105 = ((Map.Entry) r103).getValue();     // Catch: Exception -> L12
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        r101.put(r104, r105);     // Catch: Exception -> L12
        goto L5
    L10:
        return new JSONObject(r101);
    L12:
        e = move-exception;
        CJLogger.b("JsonUtils", "map2JsonWithNullToBlank fail " + e);
        return new JSONObject();
    }

    public static JSONObject c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter("pwd", "trimKey");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        if (Intrinsics.areEqual(r103, "pwd") == true) goto L4;
        r101.putOpt(r103, r100.opt(r103));
        goto L4
    L8:
        return r101;
    }

    public static void b(JSONObject r100, Map r101) {
        if (r101 == null) goto L29;
        if (r100 == null) goto L30;
        Iterator r102 = r101.keySet().iterator();     // Catch: Exception -> L14
    L5:
        if (r102.hasNext() == false) goto L31;
        String r103 = (String) r102.next();     // Catch: Exception -> L14
        Object r104 = r101.get(r103);     // Catch: Exception -> L14
        if (r104 != null) goto L9;
        if (r103 == null) goto L5;
        r100.put(r103, "");     // Catch: Exception -> L14
        goto L5
    L9:
        if (r103 == null) goto L5;
        r100.put(r103, r104);     // Catch: Exception -> L14
        goto L5
    L31:
        return;
    L14:
        e = move-exception;
        CJLogger.c("JsonUtils", "putAllToJson error", e);
        CJReporter r105 = CJReporter.f202294a;
        CJReporter.k(null, "putAllToJson error", 2, e.toString());
        return;
    L30:
        return;
    }
}

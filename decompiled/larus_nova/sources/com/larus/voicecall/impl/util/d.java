package com.larus.voicecall.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final Object a(ouc.i r100) {
        if (Intrinsics.areEqual(r100, ouc.a0.INSTANCE) == false) goto L6;
        Object r101 = JSONObject.NULL;
    L38:
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        if ((r100 instanceof ouc.g0) == false) goto L25;
        ouc.g0 r102 = (ouc.g0) r100;
        Boolean r103 = ouc.k.f(r102);
        if (r103 != null) goto L10;
        Double r104 = ouc.k.i(r102);
        if (r104 == null) goto L21;
        double r105 = r104.doubleValue();
        long r106 = (long) r105;
        if (r105 != r106) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L20;
        return Long.valueOf(r106);
    L20:
        return Double.valueOf(r105);
    L16:
        r107 = false;
        goto L17
    L21:
        r101 = ouc.k.g(r102);
        if (r101 != null) goto L38;
        r101 = "";
        goto L38
    L10:
        return Boolean.valueOf(r103.booleanValue());
    L25:
        if ((r100 instanceof ouc.d0) == false) goto L28;
        r101 = d((ouc.d0) r100);
        goto L38
    L28:
        if ((r100 instanceof ouc.b) == false) goto L37;
        JSONArray r108 = new JSONArray();
        Iterator<ouc.i> r109 = ((ouc.b) r100).iterator();
    L31:
        if (r109.hasNext() == false) goto L36;
        Object r110 = a(r109.next());
        if (r110 != ouc.a0.INSTANCE) goto L35;
        r110 = JSONObject.NULL;
    L35:
        r108.put(r110);
        goto L31
    L36:
        r101 = r108;
        goto L38
    L37:
        r101 = r100.toString();
        goto L38
    }

    public static final ouc.i b(Object r100) {
        if (r100 == null) goto L26;
        if (r100 == JSONObject.NULL) goto L26;
        if ((r100 instanceof Boolean) == false) goto L10;
        return ouc.k.a((Boolean) r100);
    L10:
        if ((r100 instanceof Number) == false) goto L13;
        return ouc.k.b((Number) r100);
    L13:
        if ((r100 instanceof String) == false) goto L16;
        return ouc.k.c((String) r100);
    L16:
        if ((r100 instanceof JSONObject) == false) goto L19;
        return c((JSONObject) r100);
    L19:
        if ((r100 instanceof JSONArray) == false) goto L33;
        ArrayList r101 = new ArrayList();
        JSONArray r102 = (JSONArray) r100;
        int r103 = r102.length();
        int r104 = 0;
    L21:
        if (r104 >= r103) goto L32;
        ouc.i r105 = b(r102.opt(r104));
        Intrinsics.checkNotNullParameter(r105, "element");
        r101.add(r105);
        r104 = r104 + 1;
        goto L21
    L32:
        return new ouc.b(r101);
    L33:
        return ouc.k.c(r100.toString());
    L26:
        return ouc.a0.INSTANCE;
    }

    public static final ouc.d0 c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        Intrinsics.checkNotNull(r103);
        ouc.i r105 = b(r104);
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r105, "element");
        ouc.i r106 = (ouc.i) r101.put(r103, r105);
        goto L4
    L7:
        return new ouc.d0(r101);
    }

    public static final JSONObject d(ouc.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ouc.i>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, ouc.i> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = a(r103.getValue());
        if (r105 == ouc.a0.INSTANCE) goto L7;
        r101.put(r104, r105);
        goto L4
    L7:
        r101.put(r104, JSONObject.NULL);
        goto L4
    L9:
        return r101;
    }
}

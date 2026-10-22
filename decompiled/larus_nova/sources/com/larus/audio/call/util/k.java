package com.larus.audio.call.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ouc.a0;
import ouc.d0;

/* JADX INFO: loaded from: classes24.dex */
public final class k {
    public static final ouc.i a(Object r100) {
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
        return b((JSONObject) r100);
    L19:
        if ((r100 instanceof JSONArray) == false) goto L33;
        ArrayList r101 = new ArrayList();
        JSONArray r102 = (JSONArray) r100;
        int r103 = r102.length();
        int r104 = 0;
    L21:
        if (r104 >= r103) goto L32;
        ouc.i r105 = a(r102.opt(r104));
        Intrinsics.checkNotNullParameter(r105, "element");
        r101.add(r105);
        r104 = r104 + 1;
        goto L21
    L32:
        return new ouc.b(r101);
    L33:
        return ouc.k.c(r100.toString());
    L26:
        return a0.INSTANCE;
    }

    public static final d0 b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        Intrinsics.checkNotNull(r103);
        ouc.i r105 = a(r104);
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r105, "element");
        ouc.i r106 = (ouc.i) r101.put(r103, r105);
        goto L4
    L7:
        return new d0(r101);
    }
}

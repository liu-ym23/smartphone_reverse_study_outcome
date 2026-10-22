package com.obric.miniapp.lynx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class k {
    public static final List<Object> a(JSONArray r100) {
        ArrayList r101 = new ArrayList(r100.length());
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof JSONObject) == false) goto L8;
        r104 = b((JSONObject) r104);
    L13:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONArray) == false) goto L11;
        r104 = a((JSONArray) r104);
        goto L13
    L11:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L13;
        r104 = null;
        goto L13
    L14:
        return r101;
    }

    public static final Map<String, Object> b(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof JSONObject) == false) goto L9;
        r104 = b((JSONObject) r104);
    L14:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONArray) == false) goto L12;
        r104 = a((JSONArray) r104);
        goto L14
    L12:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L14;
        r104 = null;
        goto L14
    L15:
        return r101;
    }
}

package com.bytedance.locallife.common.utils;

import com.bytedance.android.ec.slice.SliceInitService;
import com.google.gson.JsonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public static final JSONObject a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return tv5.a.a(d.b(), r100);
    L6:
        return new JSONObject();
    }

    public static final String b(Object r100) {
        return d.c(r100);
    L5:
        return d.c(JsonNull.INSTANCE);
    }

    public static final JSONObject c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = SliceInitService.DEFAULT_SWITCH;
    L9:
        return new JSONObject(r100);
    L5:
        r101 = false;
        goto L6
    }

    public static final List<Object> d(JSONArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = d((JSONArray) r104);
    L10:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = e((JSONObject) r104);
        goto L10
    L11:
        return r101;
    }

    public static final Map<String, Object> e(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = d((JSONArray) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = e((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }

    public static final Map<String, Object> f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = d((JSONArray) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = e((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }

    public static final HashMap<String, String> g(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashMap<String, String> r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103).toString());
        goto L4
    L6:
        return r101;
    }
}

package com.ss.android.ugc.effectmanager.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u0007¨\u0006\b"}, d2 = {"toList", "", "", "Lorg/json/JSONArray;", "toMap", "", "", "Lorg/json/JSONObject;", "effectmanager_release"}, k = 2, mv = {1, 1, 16})
public final class JsonExtKt {
    public static final List<Object> toList(JSONArray r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = toList((JSONArray) r104);
    L10:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = toMap((JSONObject) r104);
        goto L10
    L11:
        return r101;
    }

    public static final Map<String, Object> toMap(JSONObject r100) throws JSONException {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = toList((JSONArray) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = toMap((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }
}

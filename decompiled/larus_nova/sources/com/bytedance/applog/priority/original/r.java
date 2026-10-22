package com.bytedance.applog.priority.original;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f192792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, List<List<String>>> f192793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, List<HashMap<String, String>>> f192794c;

    public r(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        this.f192792a = new LinkedHashSet();
        this.f192793b = new HashMap();
        this.f192794c = new HashMap();
        JSONArray r100 = r110.optJSONArray("events");
        if (r100 == null) goto L16;
        int r101 = r100.length();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L16;
        String r103 = r100.optString(r102);
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
        this.f192792a.add(r103);
    L15:
        r102 = r102 + 1;
        goto L5
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
    L16:
        JSONObject r105 = r110.optJSONObject("param_keys");
        if (r105 == null) goto L41;
        Iterator<String> r106 = r105.keys();
    L20:
        if (r106.hasNext() == false) goto L41;
        String r107 = r106.next();
        ArrayList r108 = new ArrayList();
        JSONArray r109 = r105.optJSONArray(r107);
        if (r109 == null) goto L40;
        int r111 = r109.length();
        int r112 = 0;
    L24:
        if (r112 >= r111) goto L40;
        JSONArray r113 = r109.optJSONArray(r112);
        ArrayList r114 = new ArrayList();
        if (r113 == null) goto L39;
        int r115 = r113.length();
        int r116 = 0;
    L28:
        if (r116 >= r115) goto L39;
        String r117 = r113.optString(r116);
        if (r117 != null) goto L32;
    L35:
        boolean r118 = true;
    L36:
        if (r118 == true) goto L38;
        r114.add(r117);
    L38:
        r116 = r116 + 1;
        goto L28
    L32:
        if (r117.length() == 0) goto L35;
        r118 = false;
    L39:
        r108.add(r114);
        r112 = r112 + 1;
    L40:
        this.f192793b.put(r107, r108);
    L41:
        JSONObject r119 = r110.optJSONObject("param_key_values");
        if (r119 == null) goto L58;
        Iterator<String> r120 = r119.keys();
    L45:
        if (r120.hasNext() == false) goto L74;
        String r121 = r120.next();
        ArrayList r122 = new ArrayList();
        JSONArray r123 = r119.optJSONArray(r121);
        if (r123 == null) goto L57;
        int r124 = r123.length();
        int r125 = 0;
    L49:
        if (r125 >= r124) goto L57;
        JSONObject r126 = r123.optJSONObject(r125);
        HashMap r127 = new HashMap();
        if (r126 == null) goto L56;
        Iterator<String> r128 = r126.keys();
    L54:
        if (r128.hasNext() == false) goto L56;
        String r129 = r128.next();
        r127.put(r129, r126.optString(r129));
    L56:
        r122.add(r127);
        r125 = r125 + 1;
    L57:
        this.f192794c.put(r121, r122);
        goto L45
    L74:
        return;
    }
}

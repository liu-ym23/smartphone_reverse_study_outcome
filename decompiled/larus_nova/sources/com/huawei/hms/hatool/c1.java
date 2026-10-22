package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class c1 {
    public static Map<String, List<b1>> a(Context r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<String, ?> r102 = d.a(r100, r101);
        b(r102);
        return a(r102);
    }

    public static Map<String, List<b1>> a(Context r100, String r101, String r102) {
        int r103 = q0.h() * 1048576;
        if (c0.a(r100, "cached_v2_1", r103) == false) goto L6;
        v.f("hmsSdk", "cached event reach max size, delete it");
        d.a(r100, "cached_v2_1", new String[0]);
    L6:
        if (c0.a(r100, "stat_v2_1", r103) == false) goto L9;
        v.f("hmsSdk", "stat event reach max size, delete it");
        d.a(r100, "stat_v2_1", new String[0]);
    L9:
        if ("alltype".equals(r102) == false) goto L11;
    L14:
        v.a("hmsSdk", "read all event records");
        Map<String, List<b1>> r104 = a(r100, "stat_v2_1");
        Map<String, List<b1>> r105 = a(r100, "cached_v2_1");
    L16:
        return a(r104, r105);
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        String r106 = n1.a(r101, r102);
        r104 = b(r100, "stat_v2_1", r106);
        r105 = b(r100, "cached_v2_1", r106);
        goto L16
    }

    private static Map<String, List<b1>> a(Map<String, ?> r100) {
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, ?> r103 = r102.next();
        String r104 = r103.getKey();
        if ((r103.getValue() instanceof String) == false) goto L4;
        a(r104, (String) r103.getValue(), r101);
        goto L4
    L8:
        return r101;
    }

    private static Map<String, List<b1>> a(Map<String, List<b1>> r100, Map<String, List<b1>> r101) {
        if (r100.size() != 0) goto L9;
        if (r101.size() != 0) goto L9;
        return new HashMap();
    L9:
        if (r100.size() != 0) goto L12;
        return r101;
    L12:
        if (r101.size() != 0) goto L14;
        return r100;
    L14:
        HashMap r102 = new HashMap(r100);
        r102.putAll(r101);
        return r102;
    }

    private static void a(String r100, String r101, Map<String, List<b1>> r102) {
        ArrayList r103 = new ArrayList();
    L20:
        v.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        JSONArray r104 = new JSONArray(r101);     // Catch: JSONException -> L20
        if (r104.length() != 0) goto L10;
        return;
    L10:
        int r105 = 0;
    L12:
        if (r105 >= r104.length()) goto L18;
        b1 r106 = new b1();
        r106.a(JSONArrayProtectorUtils.getJSONObject(r104, r105));     // Catch: JSONException -> L16
        r103.add(r106);     // Catch: JSONException -> L16
    L17:
        r105 = r105 + 1;
    L16:
        v.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
        goto L17
    L18:
        r102.put(r100, r103);
    }

    public static Map<String, List<b1>> b(Context r100, String r101, String r102) {
        String r103 = d.a(r100, r101, r102, "");
        HashMap r104 = new HashMap();
        a(r102, r103, r104);
        return r104;
    }

    private static void b(Map<String, ?> r100) {
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
        Set<String> r102 = n1.a(q0.b());
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r102.contains(r101.next().getKey()) == true) goto L4;
        r101.remove();
        goto L4
    }
}

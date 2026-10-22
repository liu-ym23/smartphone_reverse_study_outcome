package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static JSONObject c() {
        int r0 = or3.a.a;
        return new JSONObject();
    }

    public static String a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        String r3 = r2.toString();
        if (r3 != null) goto L6;
        return "{}";
    L6:
        return r3;
    }

    public static String b(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonMap");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "jsonMap");
        Intrinsics.checkNotNullParameter(r2, "jsonMap");
        JSONObject r0 = new JSONObject(MapsKt.toMap(r2));     // Catch: Exception -> L5
    L6:
        String r3 = r0.toString();
        if (r3 != null) goto L12;
        return "{}";
    L12:
        return r3;
    L5:
        r0 = new JSONObject();
        goto L6
    }

    public static JSONObject d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonString");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "jsonString");
        return new JSONObject(r2);
    L6:
        return new JSONObject();
    }

    public static JSONObject e(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonMap");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "jsonMap");
        return new JSONObject(MapsKt.toMap(r2));
    L6:
        return new JSONObject();
    }

    public static int h(JSONArray r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonArr");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "jsonArr");
        return r2.length();
    }

    public static ArrayList k(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "jsonObj");
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        return new ArrayList(SequencesKt.toList(SequencesKt.asSequence(r2)));
    L6:
        return com.bytedance.rts.foundation.j.k(new String[0]);
    }

    public static boolean q(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        int r1 = or3.a.a;
        Intrinsics.checkNotNullParameter(r2, "obj");
        return r2 instanceof JSONObject;
    }

    public static JSONObject i(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = or3.a.a;
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        return r3.optJSONObject(r4);
    }

    public static Object m(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = or3.a.a;
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        return r3.opt(r4);
    }

    public static String o(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = or3.a.a;
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        return r3.optString(r4);
    }

    public static String p(JSONObject r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "jsonObj");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        int r4 = or3.a.a;
        Intrinsics.checkNotNullParameter(r5, "jsonObj");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        return r5.optString(r6, "");
    }

    public static int f(JSONObject r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = or3.a.a;
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r0 = r3.opt(r4);
        if ((r0 instanceof Boolean) == false) goto L11;
        Integer r6 = Integer.valueOf(((Boolean) r0).booleanValue() ? 1 : 0);
    L8:
        if (r6 != null) goto L10;
        return r5;
    L10:
        return r6.intValue();
    L11:
        r6 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r3, r4));     // Catch: Exception -> L7
    L7:
        r6 = null;
        goto L8
    }

    public static JSONArray g(JSONObject r4, String r5, JSONArray r6) {
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        int r3 = or3.a.a;
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        JSONArray r7 = r4.optJSONArray(r5);
        if (r7 != null) goto L6;
        return r6;
    L6:
        return r7;
    }

    public static JSONObject j(JSONObject r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        int r3 = or3.a.a;
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        JSONObject r7 = r4.optJSONObject(r5);
        if (r7 != null) goto L6;
        return r6;
    L6:
        return r7;
    }

    public static long l(JSONObject r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = or3.a.a;
        Intrinsics.checkNotNullParameter(r3, "jsonObj");
        Intrinsics.checkNotNullParameter(r4, "key");
        Long r6 = or3.a.c(r3, r4);
        if (r6 != null) goto L5;
        return r5;
    L5:
        return r6.longValue();
    }

    public static Object n(JSONObject r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        int r3 = or3.a.a;
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        Object r7 = r4.opt(r5);
        if (r7 != null) goto L6;
        return r6;
    L6:
        return r7;
    }

    public static void r(JSONObject r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        int r3 = or3.a.a;
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.put(r5, r6);
    }
}

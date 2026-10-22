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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public final Set<String> a;
    public final HashMap<String, List<List<String>>> b;
    public final HashMap<String, List<HashMap<String, String>>> c;

    public r(JSONObject r18) {
        Intrinsics.checkNotNullParameter(r18, "json");
        this.a = new LinkedHashSet();
        this.b = new HashMap();
        this.c = new HashMap();
        JSONArray r2 = r18.optJSONArray("events");
        if (r2 == null) goto L16;
        int r5 = r2.length();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L16;
        String r7 = r2.optString(r6);
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L15;
        this.a.add(r7);
    L15:
        r6 = r6 + 1;
        goto L5
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
    L16:
        JSONObject r3 = r18.optJSONObject("param_keys");
        if (r3 == null) goto L41;
        Iterator<String> r9 = r3.keys();
    L20:
        if (r9.hasNext() == false) goto L41;
        String r10 = r9.next();
        ArrayList r11 = new ArrayList();
        JSONArray r12 = r3.optJSONArray(r10);
        if (r12 == null) goto L40;
        int r13 = r12.length();
        int r14 = 0;
    L24:
        if (r14 >= r13) goto L40;
        JSONArray r15 = r12.optJSONArray(r14);
        ArrayList r16 = new ArrayList();
        if (r15 == null) goto L39;
        int r17 = r15.length();
        int r19 = 0;
    L28:
        if (r19 >= r17) goto L39;
        String r110 = r15.optString(r19);
        if (r110 != null) goto L32;
    L35:
        boolean r111 = true;
    L36:
        if (r111 == true) goto L38;
        r16.add(r110);
    L38:
        r19 = r19 + 1;
        goto L28
    L32:
        if (r110.length() == 0) goto L35;
        r111 = false;
    L39:
        r11.add(r16);
        r14 = r14 + 1;
    L40:
        this.b.put(r10, r11);
    L41:
        JSONObject r1 = r18.optJSONObject("param_key_values");
        if (r1 == null) goto L58;
        Iterator<String> r4 = r1.keys();
    L45:
        if (r4.hasNext() == false) goto L74;
        String r20 = r4.next();
        ArrayList r21 = new ArrayList();
        JSONArray r22 = r1.optJSONArray(r20);
        if (r22 == null) goto L57;
        int r23 = r22.length();
        int r24 = 0;
    L49:
        if (r24 >= r23) goto L57;
        JSONObject r25 = r22.optJSONObject(r24);
        HashMap r112 = new HashMap();
        if (r25 == null) goto L56;
        Iterator<String> r113 = r25.keys();
    L54:
        if (r113.hasNext() == false) goto L56;
        String r114 = r113.next();
        r112.put(r114, r25.optString(r114));
    L56:
        r21.add(r112);
        r24 = r24 + 1;
    L57:
        this.c.put(r20, r21);
        goto L45
    L74:
        return;
    }
}

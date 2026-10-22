package com.bytedance.ies.tools.prefetch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<c0>> f248827a;

    public r(JSONObject r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<String> r101 = r110.keys();
    L4:
        if (r101.hasNext() == false) goto L17;
        String r102 = r101.next();
        Object r103 = r110.opt(r102);
        int r104 = 0;
        if ((r103 instanceof JSONObject) == true) goto L7;
        if ((r103 instanceof JSONArray) == false) goto L4;
        ArrayList r105 = new ArrayList();
        JSONArray r106 = (JSONArray) r103;
        int r107 = r106.length();
    L11:
        if (r104 >= r107) goto L16;
        JSONObject r108 = r106.optJSONObject(r104);
        if (r108 == null) goto L15;
        r105.add(new c0(r102, r108));
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        r100.put(r102, r105);
        goto L4
    L7:
        r100.put(r102, CollectionsKt.mutableListOf(new c0[]{new c0(r102, (JSONObject) r103)}));
        goto L4
    L17:
        this.f248827a = r100;
    }
}

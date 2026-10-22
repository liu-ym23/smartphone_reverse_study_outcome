package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f271813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f271814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f271815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, f> f271816e;

    public final boolean a() {
        if (this.f271813b > 0) goto L5;
        return false;
    L5:
        HashMap<String, f> r100 = this.f271816e;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, f>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        Map.Entry<String, f> r103 = r102.next();
        f r104 = r103.getValue();
        if (r104.f271804a == 0) goto L11;
    L15:
        boolean r105 = false;
    L17:
        if ((true ^ r105) == false) goto L7;
        r101.put(r103.getKey(), r103.getValue());
        goto L7
    L11:
        if (r104.f271806c != 0) goto L15;
        if (r104.f271808e != 0) goto L15;
        r105 = true;
        goto L17
    L20:
        return !r101.isEmpty();
    }

    public g() {
        this.f271814c = new b(0);
        this.f271815d = new e(0);
        this.f271816e = new HashMap();
    }

    public static b b(JSONObject r100) {
        return new b(r100.optInt("java_release_strategy"), r100.optInt("java_available_memory"), r100.optInt("physics_release_strategy"), r100.optInt("physics_available_memory"), r100.optInt("virtual_release_strategy"), r100.optInt("virtual_available_memory"));
    }

    public static HashMap c(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 != null) goto L9;
        r104 = new JSONObject();
    L9:
        r101.put(r103, b(r104));
        goto L4
    L10:
        return r101;
    }
}

package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d> f277279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<b> f277280d;

    public c() {
        this.f277279c = new ConcurrentHashMap(16);
        this.f277280d = new ArrayList(16);
    }

    public d a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    L7:
        return this.f277279c.get(r100);
    }

    public List<b> a() {
        return this.f277280d;
    }

    public void a(String r100, d r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L8;
        this.f277279c.put(r100, r101);
        return;
    L8:
        return;
    }

    public void a(List<b> r100) {
        this.f277280d = r100;
    }

    public String b() {
        return this.f277278b;
    }

    public void b(String r100) {
        this.f277277a = r100;
    }

    public JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("name", this.f277277a);
        r100.put("routeBy", this.f277278b);
        JSONArray r101 = new JSONArray();
        Iterator<String> r102 = this.f277279c.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        d r104 = this.f277279c.get(r103);
        if (r104 == null) goto L4;
        r101.put(r104.c());
        goto L4
    L8:
        r100.put("servings", r101);
        if (this.f277280d == null) goto L15;
        JSONArray r105 = new JSONArray();
        Iterator<b> r106 = this.f277280d.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r105.put(r106.next().c());
        goto L12
    L14:
        r100.put("countryGroups", r105);
    L15:
        return r100;
    }

    public void c(String r100) {
        this.f277278b = r100;
    }
}

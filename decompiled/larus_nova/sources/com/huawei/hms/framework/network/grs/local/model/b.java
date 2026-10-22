package com.huawei.hms.framework.network.grs.local.model;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f277275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277276d;

    public b() {
    }

    public Set<String> a() {
        return this.f277275c;
    }

    public void a(String r100) {
        this.f277276d = r100;
    }

    public void a(Set<String> r100) {
        this.f277275c = r100;
    }

    public String b() {
        return this.f277273a;
    }

    public void b(String r100) {
        this.f277273a = r100;
    }

    public JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("id", this.f277273a);
        r100.put("name", this.f277274b);
        JSONArray r101 = new JSONArray();
        Iterator<String> r102 = this.f277275c.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.put(r102.next());
        goto L4
    L6:
        r100.put("countries", r101);
        r100.put("description", this.f277276d);
        return r100;
    }

    public void c(String r100) {
        this.f277274b = r100;
    }
}

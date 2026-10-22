package com.huawei.hms.framework.network.grs.local.model;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f277282b;

    public d() {
    }

    public Map<String, String> a() {
        return this.f277282b;
    }

    public void a(String r100) {
        this.f277281a = r100;
    }

    public void a(Map<String, String> r100) {
        this.f277282b = r100;
    }

    public String b() {
        return this.f277281a;
    }

    public JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("countryGroup", this.f277281a);
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = this.f277282b.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, this.f277282b.get(r103));
        goto L4
    L6:
        r100.put("addresses", r101);
        return r100;
    }
}

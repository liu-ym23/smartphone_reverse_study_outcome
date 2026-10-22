package com.huawei.hms.hatool;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class l extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f277390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277391g;

    public l() {
        this.f277386b = "";
        this.f277387c = "";
        this.f277388d = "";
        this.f277389e = "";
        this.f277390f = "";
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("androidid", this.f277455a);
        r100.put("oaid", this.f277391g);
        r100.put(ST.UUID_DEVICE, this.f277390f);
        r100.put("upid", this.f277389e);
        r100.put("imei", this.f277386b);
        r100.put("sn", this.f277387c);
        r100.put("udid", this.f277388d);
        return r100;
    }

    public void b(String r100) {
        this.f277386b = r100;
    }

    public void c(String r100) {
        this.f277391g = r100;
    }

    public void d(String r100) {
        this.f277387c = r100;
    }

    public void e(String r100) {
        this.f277388d = r100;
    }

    public void f(String r100) {
        this.f277389e = r100;
    }

    public void g(String r100) {
        this.f277390f = r100;
    }
}

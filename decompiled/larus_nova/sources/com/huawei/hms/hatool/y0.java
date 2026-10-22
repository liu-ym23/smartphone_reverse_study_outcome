package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class y0 extends t0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f277473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f277474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f277475h;

    public y0() {
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("_rom_ver", this.f277475h);
        r100.put("_emui_ver", this.f277456a);
        r100.put("_model", Build.MODEL);
        r100.put("_mcc", this.f277473f);
        r100.put("_mnc", this.f277474g);
        r100.put("_package_name", this.f277457b);
        r100.put("_app_ver", this.f277458c);
        r100.put("_lib_ver", "2.2.0.315");
        r100.put("_channel", this.f277459d);
        r100.put("_lib_name", "hianalytics");
        r100.put("_oaid_tracking_flag", this.f277460e);
        return r100;
    }

    public void f(String r100) {
        this.f277473f = r100;
    }

    public void g(String r100) {
        this.f277474g = r100;
    }

    public void h(String r100) {
        this.f277475h = r100;
    }
}

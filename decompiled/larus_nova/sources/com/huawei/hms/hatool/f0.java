package com.huawei.hms.hatool;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class f0 extends k0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277329g;

    public f0() {
        this.f277329g = "";
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("protocol_version", "3");
        r100.put("compress_mode", "1");
        r100.put("serviceid", this.f277383d);
        r100.put("appid", this.f277380a);
        r100.put("hmac", this.f277329g);
        r100.put("chifer", this.f277385f);
        r100.put("timestamp", this.f277381b);
        r100.put("servicetag", this.f277382c);
        r100.put("requestid", this.f277384e);
        return r100;
    }

    public void g(String r100) {
        this.f277329g = r100;
    }
}

package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class s extends am {
    public s() {
    }

    public s a(JSONObject r100) {
        this.f277495a = r100.optString("appId", null);
        this.f277496b = r100.optString("packageName", null);
        this.f277497c = r100.optLong("hmsSdkVersion");
        this.f277498d = r100.optString("subAppId", null);
        return this;
    }

    public static s a(String r100) throws JSONException {
        JSONObject r101 = new JSONObject(r100);
        return new s().a(r101);
    }
}

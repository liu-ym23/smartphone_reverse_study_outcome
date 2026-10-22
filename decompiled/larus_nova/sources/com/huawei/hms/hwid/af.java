package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277492a;

    public String a() {
        JSONObject r100 = new JSONObject();
        r100.put("packageName", this.f277492a);     // Catch: JSONException -> L6
        return r100.toString();
    L6:
        as.d("ReadSmsInputBean", "toJson failed", true);
        return null;
    }

    public af() {
    }

    public af(String r100) {
        this.f277492a = r100;
    }
}

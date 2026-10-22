package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdGetTokenOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277742b;

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(this.f277741a) == true) goto L5;
        r100.put("accountName", this.f277741a);
    L5:
        r100.put("fromGetToken", this.f277742b);
        return r100;
    }

    public String getAccountName() {
        return this.f277741a;
    }

    public boolean isFromGetToken() {
        return this.f277742b;
    }

    public static HuaweiIdGetTokenOptions fromJsonObject(JSONObject r100) throws JSONException {
        return new HuaweiIdGetTokenOptions(r100.optString("accountName"), r100.optBoolean("fromGetToken", false));
    }

    public void setAccountName(String r100) {
        this.f277741a = r100;
    }

    public void setFromGetToken(boolean r100) {
        this.f277742b = r100;
    }

    public HuaweiIdGetTokenOptions(String r100, boolean r101) {
        this.f277741a = r100;
        this.f277742b = r101;
    }
}

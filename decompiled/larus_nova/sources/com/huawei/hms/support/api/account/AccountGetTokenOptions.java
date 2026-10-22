package com.huawei.hms.support.api.account;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountGetTokenOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277720b;

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(this.f277719a) == true) goto L5;
        r100.put("accountName", this.f277719a);
    L5:
        r100.put("fromGetToken", this.f277720b);
        return r100;
    }

    public String getAccountName() {
        return this.f277719a;
    }

    public boolean isFromGetToken() {
        return this.f277720b;
    }

    public static AccountGetTokenOptions fromJsonObject(JSONObject r100) throws JSONException {
        return new AccountGetTokenOptions(r100.optString("accountName"), r100.optBoolean("fromGetToken", false));
    }

    public void setAccountName(String r100) {
        this.f277719a = r100;
    }

    public void setFromGetToken(boolean r100) {
        this.f277720b = r100;
    }

    public AccountGetTokenOptions(String r100, boolean r101) {
        this.f277719a = r100;
        this.f277720b = r101;
    }
}

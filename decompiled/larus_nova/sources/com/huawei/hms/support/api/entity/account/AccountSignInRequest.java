package com.huawei.hms.support.api.entity.account;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.api.account.AccountGetTokenOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountSignInRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AccountAuthParams f277723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AccountGetTokenOptions f277724b;

    public AccountSignInRequest() {
    }

    public String toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        AccountAuthParams r101 = this.f277723a;
        if (r101 == null) goto L5;
        r100.put("huaweiIdSignInOptions", r101.toJsonObject());
    L5:
        AccountGetTokenOptions r102 = this.f277724b;
        if (r102 == null) goto L9;
        r100.put("accountGetTokenOptions", r102.toJsonObject());
    L9:
        return r100.toString();
    }

    public AccountAuthParams getAccountAuthParams() {
        return this.f277723a;
    }

    public AccountGetTokenOptions getAccountGetTokenOptions() {
        return this.f277724b;
    }

    public static AccountSignInRequest fromJson(String r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject(r100);
        return new AccountSignInRequest().objectFromJson(r101);
    }

    public AccountSignInRequest objectFromJson(JSONObject r100) throws JSONException {
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "huaweiIdSignInOptions");
        if (r101 == null) goto L6;
        this.f277723a = AccountAuthParams.fromJsonObject(r101);
    L6:
        if (r100.has("huaweiIdGetTokenOptions") == false) goto L12;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "accountGetTokenOptions");
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L12;
        this.f277724b = AccountGetTokenOptions.fromJsonObject(r102);
    L12:
        return this;
    }

    public void setAccountAuthParams(AccountAuthParams r100) {
        this.f277723a = r100;
    }

    public void setAccountGetTokenOptions(AccountGetTokenOptions r100) {
        this.f277724b = r100;
    }
}

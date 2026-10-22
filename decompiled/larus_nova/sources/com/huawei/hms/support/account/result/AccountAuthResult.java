package com.huawei.hms.support.account.result;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountAuthResult extends AbstractAuthResult {
    private static final String TAG_ENTITY = "signInHuaweiId";
    private AuthAccount authAccount;

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = superToJson();
        AuthAccount r101 = this.authAccount;
        if (r101 == null) goto L5;
        r100.put(TAG_ENTITY, r101.toJsonObject());
    L5:
        return r100;
    }

    public AccountAuthResult() {
    }

    public AuthAccount getAccount() {
        return this.authAccount;
    }

    public AccountAuthResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        JSONObject r101 = new JSONObject(r100);
        jsonToSuper(r101);
        JSONObject r102 = r101.optJSONObject(TAG_ENTITY);
        if (r102 == null) goto L8;
        this.authAccount = AuthAccount.fromJson(r102);
    L8:
        return this;
    }

    public void setAuthAccount(AuthAccount r100) {
        this.authAccount = r100;
    }
}

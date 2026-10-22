package com.huawei.hms.support.hwid.result;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdAuthResult extends AbstractAuthResult {
    private AuthHuaweiId authHuaweiId;

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = superToJson();
        AuthHuaweiId r101 = this.authHuaweiId;
        if (r101 == null) goto L5;
        r100.put("signInHuaweiId", r101.toJsonObject());
    L5:
        return r100;
    }

    public HuaweiIdAuthResult() {
    }

    public AuthHuaweiId getHuaweiId() {
        return this.authHuaweiId;
    }

    public HuaweiIdAuthResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        JSONObject r101 = new JSONObject(r100);
        jsonToSuper(r101);
        JSONObject r102 = r101.optJSONObject("signInHuaweiId");
        if (r102 == null) goto L8;
        this.authHuaweiId = AuthHuaweiId.fromJson(r102);
    L8:
        return this;
    }

    public void setAuthHuaweiId(AuthHuaweiId r100) {
        this.authHuaweiId = r100;
    }
}

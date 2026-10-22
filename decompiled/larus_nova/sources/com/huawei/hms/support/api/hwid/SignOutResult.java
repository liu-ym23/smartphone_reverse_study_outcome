package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class SignOutResult extends Result {
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public SignOutResult() {
    }

    public SignOutResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        jsonToSuper(new JSONObject(r100));
        return this;
    }

    public void jsonToSuper(JSONObject r100) {
        if (r100.has("errorCode") == false) goto L10;
        int r101 = r100.optInt("errorCode");
        if (r100.has("errorMsg") == false) goto L7;
        String r102 = r100.optString("errorMsg");
    L8:
        setStatus(new Status(r101, r102));
        return;
    L7:
        r102 = "";
        goto L8
    L10:
        JSONObject r103 = r100.optJSONObject("status");
        if (r103 == null) goto L14;
        setStatus(new Status(r103.optInt("statusCode"), r103.optString("statusMessage", null)));
        return;
    }
}

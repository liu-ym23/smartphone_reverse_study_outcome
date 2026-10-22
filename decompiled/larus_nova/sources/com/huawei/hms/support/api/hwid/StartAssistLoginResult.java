package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class StartAssistLoginResult extends Result {
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public StartAssistLoginResult() {
    }

    public StartAssistLoginResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        jsonToSuper(new JSONObject(r100));
        return this;
    }

    public void jsonToSuper(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("status");
        if (r101 == null) goto L6;
        setStatus(new Status(r101.optInt("statusCode"), r101.optString("statusMessage", null)));
        return;
    }
}

package com.huawei.hms.support.feature.result;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractAuthResult extends Result {
    public JSONObject superToJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (getStatus() == null) goto L8;
        JSONObject r101 = new JSONObject();
        r101.put("statusCode", getStatus().getStatusCode());
        if (getStatus().getStatusMessage() == null) goto L7;
        r101.put("statusMessage", getStatus().getStatusMessage());
    L7:
        r100.put("status", r101);
    L8:
        return r100;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public AbstractAuthResult() {
    }

    public void jsonToSuper(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("status");
        if (r101 == null) goto L6;
        setStatus(new Status(r101.optInt("statusCode"), r101.optString("statusMessage", null)));
        return;
    }
}

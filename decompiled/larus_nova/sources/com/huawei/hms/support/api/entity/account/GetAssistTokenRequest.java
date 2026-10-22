package com.huawei.hms.support.api.entity.account;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class GetAssistTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277728c;

    public String toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(this.f277726a) == true) goto L6;
        r100.putOpt("accessToken", this.f277726a);
    L6:
        if (TextUtils.isEmpty(this.f277727b) == true) goto L9;
        r100.putOpt(CommonConstant.KEY_USER_IDENTIFY, this.f277727b);
    L9:
        if (TextUtils.isEmpty(this.f277728c) == true) goto L12;
        r100.putOpt("sessionId", this.f277728c);
    L12:
        return r100.toString();
    }

    public String getSessionId() {
        return this.f277728c;
    }

    public String getUserIdentify() {
        return this.f277727b;
    }

    public GetAssistTokenRequest(String r100) {
        this.f277726a = r100;
    }

    public void setSessionId(String r100) {
        this.f277728c = r100;
    }

    public void setUserIdentify(String r100) {
        this.f277727b = r100;
    }
}

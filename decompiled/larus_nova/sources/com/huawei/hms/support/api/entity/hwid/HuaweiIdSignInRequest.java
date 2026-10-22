package com.huawei.hms.support.api.entity.hwid;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.api.hwid.HuaweiIdGetTokenOptions;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdSignInRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HuaweiIdAuthParams f277733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    HuaweiIdGetTokenOptions f277734b;

    public HuaweiIdSignInRequest() {
    }

    public String toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        HuaweiIdAuthParams r101 = this.f277733a;
        if (r101 == null) goto L5;
        r100.put("huaweiIdSignInOptions", r101.toJsonObject());
    L5:
        HuaweiIdGetTokenOptions r102 = this.f277734b;
        if (r102 == null) goto L9;
        r100.put("huaweiIdGetTokenOptions", r102.toJsonObject());
    L9:
        return r100.toString();
    }

    public HuaweiIdAuthParams getHuaweiIdAuthParams() {
        return this.f277733a;
    }

    public HuaweiIdGetTokenOptions getHuaweiIdGetTokenOptions() {
        return this.f277734b;
    }

    public static HuaweiIdSignInRequest fromJson(String r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject(r100);
        return new HuaweiIdSignInRequest().objectFromJson(r101);
    }

    public HuaweiIdSignInRequest objectFromJson(JSONObject r100) throws JSONException {
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "huaweiIdSignInOptions");
        if (r101 == null) goto L6;
        this.f277733a = HuaweiIdAuthParams.fromJsonObject(r101);
    L6:
        if (r100.has("huaweiIdGetTokenOptions") == false) goto L12;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "huaweiIdGetTokenOptions");
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L12;
        this.f277734b = HuaweiIdGetTokenOptions.fromJsonObject(r102);
    L12:
        return this;
    }

    public void setHuaweiIdAuthParams(HuaweiIdAuthParams r100) {
        this.f277733a = r100;
    }

    public void setHuaweiIdGetTokenOptions(HuaweiIdGetTokenOptions r100) {
        this.f277734b = r100;
    }
}

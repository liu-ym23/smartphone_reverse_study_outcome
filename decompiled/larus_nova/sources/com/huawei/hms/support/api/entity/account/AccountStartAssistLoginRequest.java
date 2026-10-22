package com.huawei.hms.support.api.entity.account;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountStartAssistLoginRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277725a;

    public String toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        String r101 = this.f277725a;
        if (r101 == null) goto L6;
        r100.put(CommonConstant.KEY_ASSIST_TOKEN, r101);
    L6:
        return r100.toString();
    }

    public AccountStartAssistLoginRequest() {
    }

    public AccountStartAssistLoginRequest(String r100) {
        this.f277725a = r100;
    }

    public static AccountStartAssistLoginRequest fromJson(String r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject(r100);
        return new AccountStartAssistLoginRequest().objectFromJson(r101);
    }

    public AccountStartAssistLoginRequest objectFromJson(JSONObject r100) throws JSONException {
        if (r100 == null) goto L4;
        this.f277725a = JSONObjectProtectorUtils.getString(r100, CommonConstant.KEY_ASSIST_TOKEN);
    L4:
        return this;
    }
}

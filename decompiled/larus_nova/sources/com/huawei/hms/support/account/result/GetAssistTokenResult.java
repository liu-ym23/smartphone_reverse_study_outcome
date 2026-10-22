package com.huawei.hms.support.account.result;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class GetAssistTokenResult extends AbstractAuthResult {
    private String assistToken;

    public GetAssistTokenResult() {
    }

    public String getAssistToken() {
        return this.assistToken;
    }

    public GetAssistTokenResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        JSONObject r101 = new JSONObject(r100);
        this.assistToken = JSONObjectProtectorUtils.getString(r101, CommonConstant.KEY_ASSIST_TOKEN);
        jsonToSuper(r101);
        return this;
    }
}

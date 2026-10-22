package com.huawei.hms.support.account.result;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class GetChannelResult extends AbstractAuthResult {
    private String description;
    private String icon;

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        return superToJson();
    }

    public GetChannelResult() {
    }

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public GetChannelResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        JSONObject r101 = new JSONObject(r100);
        this.description = JSONObjectProtectorUtils.getString(r101, "description");
        this.icon = JSONObjectProtectorUtils.getString(r101, "icon");
        jsonToSuper(r101);
        return this;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setIcon(String r100) {
        this.icon = r100;
    }
}

package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class SignInByQrCodeResult extends AbstractAuthResult {
    public SignInByQrCodeResult() {
    }

    public SignInByQrCodeResult fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        jsonToSuper(new JSONObject(r100));
        return this;
    }
}

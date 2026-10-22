package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements NetService.c<DocumentSettingInfo> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r4) {
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L8
        if (r1.optInt("code") != 0) goto L13;
        return (DocumentSettingInfo) new Gson().fromJson(r1.optString("data"), DocumentSettingInfo.class);
    L13:
        return null;
    L8:
        th = move-exception;
        tt5.a.d("DocumentSettingParser", th.getMessage());
        return null;
    }
}

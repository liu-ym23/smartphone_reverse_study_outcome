package com.bytedance.ee.bear.middleground.permission.foridden;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements NetService.c<GetComplaintResult> {
    public b() {
    }

    public final Result parse(String r4) throws NetService.ParseException {
        GetComplaintResult r0 = new GetComplaintResult();
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L5
        r0.setCode(r1.optInt("code"));     // Catch: JSONException -> L5
        r0.setResult(r1.optJSONObject(WikiFolderPushPlugin.DATA).optInt("result"));     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.d("GetComplaintParser", "parse()...error = " + e);
        goto L7
    }
}

package com.bytedance.ee.bear.middleground.permission.foridden;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements NetService.c<GetComplaintResult> {
    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        GetComplaintResult r101 = new GetComplaintResult();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L5
        r101.setCode(r102.optInt("code"));     // Catch: JSONException -> L5
        r101.setResult(r102.optJSONObject("data").optInt("result"));     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        tt5.a.d("GetComplaintParser", "parse()...error = " + e);
        goto L7
    }
}

package com.bytedance.ee.bear.list.folder.complaint;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements NetService.c<SendComplaintResult> {
    public k() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        SendComplaintResult r101 = new SendComplaintResult();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L5
        r101.setCode(r102.optInt("code"));     // Catch: JSONException -> L5
        r101.setComplaintId(r102.optJSONObject("data").optInt("id"));     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        tt5.a.d("SendComplaintParser", "parse()...error = " + e);
        goto L7
    }
}

package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j0 implements NetService.c<PermCostInfo> {
    public j0() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r4) {
        if (r4 == null) goto L8;
        JSONObject r5 = new JSONObject(r4).optJSONObject("data");
        if (r5 != null) goto L7;
        r5 = new JSONObject();
    L7:
        return new PermCostInfo(r5.optBoolean("rowPermitted"), r5.optBoolean("fieldPermitted"));
    L8:
        tt5.a.d("PermCostInfoParser", "parse cost info err");
        throw new NetService.ParseException();
    }
}

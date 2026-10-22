package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class j0 implements NetService.c<PermCostInfo> {
    public j0() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 == null) goto L8;
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        return new PermCostInfo(r101.optBoolean("rowPermitted"), r101.optBoolean("fieldPermitted"));
    L8:
        tt5.a.d("PermCostInfoParser", "parse cost info err");
        throw new NetService.ParseException();
    }
}

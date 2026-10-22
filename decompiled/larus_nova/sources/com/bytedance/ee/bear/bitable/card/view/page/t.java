package com.bytedance.ee.bear.bitable.card.view.page;

import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class t implements NetService.c<RecordSubscribeStatusResult> {
    public t() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        RecordSubscribeStatusResult r101 = new RecordSubscribeStatusResult();
        if (r100 != null) goto L10;
    L9:
        return r101;
    L10:
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L7
        r101.msg = r102.optString("msg");     // Catch: Exception -> L7
        r101.code = r102.optInt("code");     // Catch: Exception -> L7
        r101.setData((RecordSubscribeStatusResult.SubscribeStatusResultData) BTJson.f209798c.a(r102.optString("data"), RecordSubscribeStatusResult.SubscribeStatusResultData.class));     // Catch: Exception -> L7
    L7:
        e = move-exception;
        tt5.a.d("RecordSubscribePresenter", String.valueOf(e.getMessage()));
        goto L9
    }
}

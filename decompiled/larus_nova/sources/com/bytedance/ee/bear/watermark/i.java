package com.bytedance.ee.bear.watermark;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements NetService.c<WatermarkConfigPuller$WatermarkResult> {
    public i() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        WatermarkConfigPuller$WatermarkResult r101 = new WatermarkConfigPuller$WatermarkResult();
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L11
        if (r102 == null) goto L13;
        boolean r103 = true;
        if (JSONObjectProtectorUtils.getInt(r102, "enable_watermark") == 1) goto L9;
        r103 = false;
    L9:
        r101.showWatermark = r103;     // Catch: JSONException -> L11
    L13:
        return r101;
    L11:
        e = move-exception;
        tt5.a.e("WatermarkExecutor ", "parse fail", e, false);
        goto L13
    }
}

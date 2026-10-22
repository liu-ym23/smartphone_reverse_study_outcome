package com.bytedance.ee.bear.watermark;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements NetService.c<WatermarkConfigPuller$WatermarkResult> {
    public i() {
    }

    public final Result parse(String r5) throws NetService.ParseException {
        WatermarkConfigPuller$WatermarkResult r0 = new WatermarkConfigPuller$WatermarkResult();
        JSONObject r6 = new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L11
        if (r6 == null) goto L13;
        boolean r2 = true;
        if (JSONObjectProtectorUtils.getInt(r6, "enable_watermark") == 1) goto L9;
        r2 = false;
    L9:
        r0.showWatermark = r2;     // Catch: JSONException -> L11
    L13:
        return r0;
    L11:
        e = move-exception;
        tt5.a.e("WatermarkExecutor ", "parse fail", e, false);
        goto L13
    }
}

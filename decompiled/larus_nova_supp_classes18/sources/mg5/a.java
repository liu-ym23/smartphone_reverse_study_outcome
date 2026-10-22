package mg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<BatchAuthorizeResult> {
    public a() {
    }

    public final Result parse(String r5) throws NetService.ParseException {
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L8
        if (r1.optInt("code") != 0) goto L13;
        BatchAuthorizeResult r6 = new BatchAuthorizeResult();     // Catch: Exception -> L8
        r6.setBatchData((BatchAuthorizeResult.BatchAuthorizeData) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), BatchAuthorizeResult.BatchAuthorizeData.class));     // Catch: Exception -> L8
        r6.setSuccess(true);     // Catch: Exception -> L8
        return r6;
    L13:
        return null;
    L8:
        e = move-exception;
        tt5.a.f("BathAuthorizeParser", e, false);
        return null;
    }
}

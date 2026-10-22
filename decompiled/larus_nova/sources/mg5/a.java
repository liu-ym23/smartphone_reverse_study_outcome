package mg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeResult;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<BatchAuthorizeResult> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
        if (r101.optInt("code") != 0) goto L13;
        BatchAuthorizeResult r102 = new BatchAuthorizeResult();     // Catch: Exception -> L8
        r102.setBatchData((BatchAuthorizeResult.BatchAuthorizeData) new Gson().fromJson(r101.optString("data"), BatchAuthorizeResult.BatchAuthorizeData.class));     // Catch: Exception -> L8
        r102.setSuccess(true);     // Catch: Exception -> L8
        return r102;
    L13:
        return null;
    L8:
        e = move-exception;
        tt5.a.f("BathAuthorizeParser", e, false);
        return null;
    }
}

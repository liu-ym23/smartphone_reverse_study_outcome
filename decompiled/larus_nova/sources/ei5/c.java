package ei5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.secret.model.SecretApprovalResultModel;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements NetService.c<SecretApprovalResultModel> {
    public c() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L9
        if (r101.optInt("code") != 0) goto L14;
        SecretApprovalResultModel r102 = (SecretApprovalResultModel) new Gson().fromJson(r101.optString("data"), SecretApprovalResultModel.class);     // Catch: Throwable -> L9
        if (r102 != null) goto L16;
        return null;
    L16:
        return r102;
    L14:
        return null;
    L9:
        th = move-exception;
        tt5.a.f("SecretApprovalParser", th, false);
        return null;
    }
}

package ei5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<SecretApprovalDefModel> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L10
        if (r101.optInt("code") != 0) goto L15;
        SecretApprovalDefModel r102 = (SecretApprovalDefModel) new Gson().fromJson(r101.optString("data"), SecretApprovalDefModel.class);     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        r102.setSuccess(true);     // Catch: Throwable -> L10
        return r102;
    L16:
        return null;
    L15:
        return null;
    L10:
        th = move-exception;
        tt5.a.f("SecretApprovalDefParser", th, false);
        return null;
    }
}

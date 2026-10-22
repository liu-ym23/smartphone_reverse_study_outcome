package nh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements NetService.c<DlpPolicyModel> {
    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L12
        if (r101.optInt("code") != 0) goto L17;
        DlpPolicyModel r102 = (DlpPolicyModel) new Gson().fromJson(r101.optString("data"), DlpPolicyModel.class);     // Catch: Exception -> L12
        if (r102 == null) goto L18;
        if (r102.getPolicy() == null) goto L18;
        r102.getPolicy().setDlpUpdateTime(System.currentTimeMillis());     // Catch: Exception -> L12
    L18:
        return r102;
    L17:
        return null;
    L12:
        e = move-exception;
        tt5.a.f("DlpPolicyModelParser", e, false);
        return null;
    }
}

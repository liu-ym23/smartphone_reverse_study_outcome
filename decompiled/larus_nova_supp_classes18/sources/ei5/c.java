package ei5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.secret.model.SecretApprovalResultModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements NetService.c<SecretApprovalResultModel> {
    public c() {
    }

    public final Result parse(String r4) throws NetService.ParseException {
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L9
        if (r1.optInt("code") != 0) goto L14;
        SecretApprovalResultModel r5 = (SecretApprovalResultModel) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), SecretApprovalResultModel.class);     // Catch: Throwable -> L9
        if (r5 != null) goto L16;
        return null;
    L16:
        return r5;
    L14:
        return null;
    L9:
        th = move-exception;
        tt5.a.f("SecretApprovalParser", th, false);
        return null;
    }
}

package ei5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<SecretApprovalDefModel> {
    public a() {
    }

    public final Result parse(String r4) throws NetService.ParseException {
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L10
        if (r1.optInt("code") != 0) goto L15;
        SecretApprovalDefModel r5 = (SecretApprovalDefModel) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), SecretApprovalDefModel.class);     // Catch: Throwable -> L10
        if (r5 == null) goto L16;
        r5.setSuccess(true);     // Catch: Throwable -> L10
        return r5;
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

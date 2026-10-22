package nh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements NetService.c<DlpPolicyModel> {
    public b() {
    }

    public final Result parse(String r5) throws NetService.ParseException {
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L12
        if (r1.optInt("code") != 0) goto L17;
        DlpPolicyModel r6 = (DlpPolicyModel) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), DlpPolicyModel.class);     // Catch: Exception -> L12
        if (r6 == null) goto L18;
        if (r6.getPolicy() == null) goto L18;
        r6.getPolicy().setDlpUpdateTime(System.currentTimeMillis());     // Catch: Exception -> L12
    L18:
        return r6;
    L17:
        return null;
    L12:
        e = move-exception;
        tt5.a.f("DlpPolicyModelParser", e, false);
        return null;
    }
}

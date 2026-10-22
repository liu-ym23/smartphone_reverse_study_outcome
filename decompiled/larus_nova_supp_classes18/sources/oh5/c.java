package oh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements NetService.c<CreateInstanceResult> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final Result parse(String r4) {
        if (r4 == null) goto L19;
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L11
        if (r1.optInt("code") != 0) goto L16;
        CreateInstanceResult r5 = (CreateInstanceResult) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), CreateInstanceResult.class);     // Catch: Throwable -> L11
        if (r5 != null) goto L18;
        return null;
    L18:
        return r5;
    L16:
        return null;
    L11:
        th = move-exception;
        tt5.a.f("CreateInstanceParser", th, false);
        return null;
    L19:
        return null;
    }
}

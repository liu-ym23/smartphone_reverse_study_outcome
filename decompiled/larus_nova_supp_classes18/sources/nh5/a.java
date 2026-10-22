package nh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<DlpCheckResult> {
    public a() {
    }

    public final Result parse(String r6) throws NetService.ParseException {
        JSONObject r1 = new JSONObject(r6);     // Catch: Exception -> L21
        if (r1.optInt("code") != 0) goto L32;
        DlpCheckResult r7 = (DlpCheckResult) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), DlpCheckResult.class);     // Catch: Exception -> L21
        if (r7 == null) goto L33;
        if (r7.getResultMap() == null) goto L33;
        if (r7.getResultMap().size() <= 0) goto L33;
        Iterator<DlpCheckResult.DlpResult> r2 = r7.getResultMap().values().iterator();     // Catch: Exception -> L21
    L14:
        if (r2.hasNext() == false) goto L33;
        DlpCheckResult.DlpResult r3 = r2.next();     // Catch: Exception -> L21
        if (r3 == null) goto L14;
        r3.setScsUpdateTime(System.currentTimeMillis());     // Catch: Exception -> L21
    L33:
        return r7;
    L32:
        return null;
    L21:
        e = move-exception;
        tt5.a.f("DlpCheckResultParser", e, false);
        return null;
    }
}

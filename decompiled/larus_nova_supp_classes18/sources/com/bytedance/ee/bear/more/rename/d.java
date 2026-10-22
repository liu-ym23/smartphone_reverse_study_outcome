package com.bytedance.ee.bear.more.rename;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements NetService.c<RenameSheetExecutor$RenameResult> {
    public d() {
    }

    public final Result parse(String r3) throws NetService.ParseException {
        tt5.a.b("RenameParser", "parse: json = " + r3);
        RenameSheetExecutor$RenameResult r0 = new RenameSheetExecutor$RenameResult();
        JSONObject r1 = new JSONObject(r3);     // Catch: JSONException -> L7
        ((Result) r0).code = r1.optInt("code");     // Catch: JSONException -> L7
        JSONObject r4 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r0.editTime = r4.optString("edit_time");     // Catch: JSONException -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}

package com.bytedance.ee.bear.list.folder.complaint;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements NetService.c<SendComplaintResult> {
    public k() {
    }

    public final Result parse(String r4) throws NetService.ParseException {
        SendComplaintResult r0 = new SendComplaintResult();
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L5
        r0.setCode(r1.optInt("code"));     // Catch: JSONException -> L5
        r0.setComplaintId(r1.optJSONObject(WikiFolderPushPlugin.DATA).optInt(ResourceData.KEY_ID));     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.d("SendComplaintParser", "parse()...error = " + e);
        goto L7
    }
}

package bi5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements NetService.c<RetentionSettingVisible> {
    public b() {
    }

    public final Result parse(String r4) throws NetService.ParseException {
        RetentionSettingVisible r1 = new RetentionSettingVisible();
        JSONObject r5 = new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L5
        r1.setToken(r5.optString(ResourceData.KEY_TOKEN));     // Catch: JSONException -> L5
        r1.setEntityType(r5.optString("entityType"));     // Catch: JSONException -> L5
        r1.setCanSetRetentionLabel(r5.optBoolean("canSetRetentionLabel"));     // Catch: JSONException -> L5
    L7:
        return r1;
    L5:
        e = move-exception;
        tt5.a.d("RetentionSettingVisibleParser", "parse()...error = " + e);
        goto L7
    }
}

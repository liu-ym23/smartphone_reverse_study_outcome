package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 implements NetService.c<DocumentCreateEntity> {
    public final boolean a;

    public h0(boolean r1) {
        this.a = r1;
    }

    public final Result parse(String r8) throws NetService.ParseException {
        DocumentCreateEntity r1 = new DocumentCreateEntity();
        JSONObject r3 = new JSONObject(r8);     // Catch: NullPointerException -> L11 JSONException -> L13
        ((Result) r1).code = r3.optInt("code");     // Catch: NullPointerException -> L11 JSONException -> L13
        ((Result) r1).msg = r3.optString("msg");     // Catch: NullPointerException -> L11 JSONException -> L13
        JSONObject r9 = r3.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: NullPointerException -> L11 JSONException -> L13
        if (this.a == false) goto L8;
        JSONArray r4 = JSONObjectProtectorUtils.getJSONArray(r9, "node_list");     // Catch: NullPointerException -> L11 JSONException -> L13
        JSONObject r10 = r9.optJSONObject("entities").optJSONObject("nodes");     // Catch: NullPointerException -> L11 JSONException -> L13
        int r5 = r4.length();     // Catch: NullPointerException -> L11 JSONException -> L13
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L9;
        a(r1, r10.optJSONObject(JSONArrayProtectorUtils.getString(r4, r6)));     // Catch: NullPointerException -> L11 JSONException -> L13
        r6 = r6 + 1;     // Catch: NullPointerException -> L11 JSONException -> L13
    L9:
        tt5.a.b("DocumentCreateParser", "parse data : " + r1);     // Catch: NullPointerException -> L11 JSONException -> L13
    L15:
        return r1;
    L8:
        r1.objToken = r9.optString(ResourceData.KEY_OBJ_TOKEN);     // Catch: NullPointerException -> L11 JSONException -> L13
        r1.token = r9.optString(ResourceData.KEY_TOKEN);     // Catch: NullPointerException -> L11 JSONException -> L13
        r1.url = r9.optString(ResourceData.KEY_URL);     // Catch: NullPointerException -> L11 JSONException -> L13
    L11:
        e = move-exception;
        tt5.a.e("DocumentCreateParser", "null pointer while parsing JSON", e, false);
    L13:
        e = move-exception;
        tt5.a.e("DocumentCreateParser", "json exception", e, false);
        goto L15
    }

    public static void a(DocumentCreateEntity r2, JSONObject r3) {
        r2.objToken = r3.optString(ResourceData.KEY_OBJ_TOKEN);     // Catch: Exception -> L6
        r2.token = r3.optString(ResourceData.KEY_TOKEN);     // Catch: Exception -> L6
        r2.ownerType = r3.optInt("owner_type");     // Catch: Exception -> L6
        r2.url = r3.optString(ResourceData.KEY_URL);     // Catch: Exception -> L6
        r2.title = r3.optString("name");     // Catch: Exception -> L6
        r2.type = r3.optInt(ResourceData.KEY_TYPE);     // Catch: Exception -> L6
        JSONObject r4 = r3.optJSONObject("extra");     // Catch: Exception -> L6
        if (r4 == null) goto L11;
        r2.isShareFolder = r4.optBoolean("is_share_folder");     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        tt5.a.e("DocumentCreateParser", "json exception", e, false);
    }
}

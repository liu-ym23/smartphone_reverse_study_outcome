package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements NetService.c<Result<ArrayList<TreeNode>>> {
    public e() {
    }

    public final Result<ArrayList<TreeNode>> parse(String r8) {
        Result<ArrayList<TreeNode>> r0 = new Result();
        JSONObject r1 = new JSONObject(r8);     // Catch: JSONException -> L9
        r0.code = r1.optInt("code");     // Catch: JSONException -> L9
        r0.msg = r1.optString("msg");     // Catch: JSONException -> L9
        JSONObject r9 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L9
        JSONArray r2 = r9.optJSONArray("node_list");     // Catch: JSONException -> L9
        JSONObject r10 = r9.optJSONObject("entities").optJSONObject("nodes");     // Catch: JSONException -> L9
        ArrayList r3 = new ArrayList();     // Catch: JSONException -> L9
        Gson r4 = new Gson();     // Catch: JSONException -> L9
        int r5 = 0;
    L5:
        if (r5 >= r2.length()) goto L7;
        r3.add((TreeNode) GsonProtectorUtils.fromJson(r4, r10.optString(r2.optString(r5)), TreeNode.class));     // Catch: JSONException -> L9
        r5 = r5 + 1;     // Catch: JSONException -> L9
        goto L5
    L7:
        r0.setData(r3);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        tt5.a.d("GetBatchNodeParser", "parse()...error = " + e);
        goto L11
    }
}

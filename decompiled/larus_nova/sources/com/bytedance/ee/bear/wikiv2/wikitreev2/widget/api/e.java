package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements NetService.c<Result<ArrayList<TreeNode>>> {
    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<ArrayList<TreeNode>> parse(String r100) {
        Result<ArrayList<TreeNode>> r101 = new Result();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L9
        r101.code = r102.optInt("code");     // Catch: JSONException -> L9
        r101.msg = r102.optString("msg");     // Catch: JSONException -> L9
        JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L9
        JSONArray r104 = r103.optJSONArray("node_list");     // Catch: JSONException -> L9
        JSONObject r105 = r103.optJSONObject("entities").optJSONObject("nodes");     // Catch: JSONException -> L9
        ArrayList r106 = new ArrayList();     // Catch: JSONException -> L9
        Gson r107 = new Gson();     // Catch: JSONException -> L9
        int r108 = 0;
    L5:
        if (r108 >= r104.length()) goto L7;
        r106.add((TreeNode) GsonProtectorUtils.fromJson(r107, r105.optString(r104.optString(r108)), TreeNode.class));     // Catch: JSONException -> L9
        r108 = r108 + 1;     // Catch: JSONException -> L9
        goto L5
    L7:
        r101.setData(r106);     // Catch: JSONException -> L9
    L11:
        return r101;
    L9:
        e = move-exception;
        tt5.a.d("GetBatchNodeParser", "parse()...error = " + e);
        goto L11
    }
}

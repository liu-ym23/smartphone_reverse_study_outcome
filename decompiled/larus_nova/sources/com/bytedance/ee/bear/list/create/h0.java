package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 implements NetService.c<DocumentCreateEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f227734a;

    public h0(boolean r100) {
        this.f227734a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        DocumentCreateEntity r101 = new DocumentCreateEntity();
        JSONObject r102 = new JSONObject(r100);     // Catch: NullPointerException -> L11 JSONException -> L13
        r101.code = r102.optInt("code");     // Catch: NullPointerException -> L11 JSONException -> L13
        r101.msg = r102.optString("msg");     // Catch: NullPointerException -> L11 JSONException -> L13
        JSONObject r103 = r102.optJSONObject("data");     // Catch: NullPointerException -> L11 JSONException -> L13
        if (this.f227734a == false) goto L8;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r103, "node_list");     // Catch: NullPointerException -> L11 JSONException -> L13
        JSONObject r105 = r103.optJSONObject("entities").optJSONObject("nodes");     // Catch: NullPointerException -> L11 JSONException -> L13
        int r106 = r104.length();     // Catch: NullPointerException -> L11 JSONException -> L13
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L9;
        a(r101, r105.optJSONObject(JSONArrayProtectorUtils.getString(r104, r107)));     // Catch: NullPointerException -> L11 JSONException -> L13
        r107 = r107 + 1;     // Catch: NullPointerException -> L11 JSONException -> L13
    L9:
        tt5.a.b("DocumentCreateParser", "parse data : " + r101);     // Catch: NullPointerException -> L11 JSONException -> L13
    L15:
        return r101;
    L8:
        r101.objToken = r103.optString("obj_token");     // Catch: NullPointerException -> L11 JSONException -> L13
        r101.token = r103.optString("token");     // Catch: NullPointerException -> L11 JSONException -> L13
        r101.url = r103.optString("url");     // Catch: NullPointerException -> L11 JSONException -> L13
    L11:
        e = move-exception;
        tt5.a.e("DocumentCreateParser", "null pointer while parsing JSON", e, false);
    L13:
        e = move-exception;
        tt5.a.e("DocumentCreateParser", "json exception", e, false);
        goto L15
    }

    public static void a(DocumentCreateEntity r100, JSONObject r101) {
        r100.objToken = r101.optString("obj_token");     // Catch: Exception -> L6
        r100.token = r101.optString("token");     // Catch: Exception -> L6
        r100.ownerType = r101.optInt("owner_type");     // Catch: Exception -> L6
        r100.url = r101.optString("url");     // Catch: Exception -> L6
        r100.title = r101.optString("name");     // Catch: Exception -> L6
        r100.type = r101.optInt("type");     // Catch: Exception -> L6
        JSONObject r102 = r101.optJSONObject("extra");     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r100.isShareFolder = r102.optBoolean("is_share_folder");     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        tt5.a.e("DocumentCreateParser", "json exception", e, false);
    }
}

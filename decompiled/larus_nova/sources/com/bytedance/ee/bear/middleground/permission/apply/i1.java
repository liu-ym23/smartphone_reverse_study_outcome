package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class i1 implements NetService.c<Result<String>> {
    public i1() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<String> parse(String r100) throws NetService.ParseException {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        tt5.a.b("PermissionApplyParser", "request return json" + r100);     // Catch: JSONException -> L6
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L6
        Result<String> r102 = new Result();     // Catch: JSONException -> L6
        r102.code = r101.optInt("code", -1);     // Catch: JSONException -> L6
        return r102;
    L6:
        e = move-exception;
        tt5.a.e("PermissionApplyParser", "sendPermissionRequest(): ", e, false);
        return null;
    L12:
        return null;
    }
}

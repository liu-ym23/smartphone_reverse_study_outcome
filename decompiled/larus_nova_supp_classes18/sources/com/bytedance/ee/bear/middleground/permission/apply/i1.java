package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i1 implements NetService.c<Result<String>> {
    public i1() {
    }

    public final Result<String> parse(String r5) throws NetService.ParseException {
        if (TextUtils.isEmpty(r5) == true) goto L12;
        tt5.a.b("PermissionApplyParser", "request return json" + r5);     // Catch: JSONException -> L6
        JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L6
        Result<String> r6 = new Result();     // Catch: JSONException -> L6
        r6.code = r1.optInt("code", -1);     // Catch: JSONException -> L6
        return r6;
    L6:
        e = move-exception;
        tt5.a.e("PermissionApplyParser", "sendPermissionRequest(): ", e, false);
        return null;
    L12:
        return null;
    }
}

package com.bytedance.ee.bear.more.rename;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements NetService.c<RenameSheetExecutor$RenameResult> {
    public d() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        tt5.a.b("RenameParser", "parse: json = " + r100);
        RenameSheetExecutor$RenameResult r101 = new RenameSheetExecutor$RenameResult();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L7
        r101.code = r102.optInt("code");     // Catch: JSONException -> L7
        JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L7
        if (r103 == null) goto L9;
        r101.editTime = r103.optString("edit_time");     // Catch: JSONException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}

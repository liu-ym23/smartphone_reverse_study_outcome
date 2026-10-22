package com.bytedance.common.utility;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class JsonUtils {
    public static void optPut(JSONObject r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}

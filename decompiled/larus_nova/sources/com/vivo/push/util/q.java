package com.vivo.push.util;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class q {
    public static Map<String, String> a(JSONObject r100) throws JSONException {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, JSONObjectProtectorUtils.getString(r100, r103));
        goto L4
    L6:
        return r101;
    }
}

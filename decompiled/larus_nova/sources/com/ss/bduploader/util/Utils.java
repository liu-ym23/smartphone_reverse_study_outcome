package com.ss.bduploader.util;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class Utils {
    public Utils() {
    }

    public static String mapToString(Map<String, Object> r100) {
        if (r100 != null) goto L15;
        return null;
    L15:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L14
        Object r104 = r100.get(r103);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r101.put(r103, r104);     // Catch: Exception -> L14
        goto L7
    L12:
        return r101.toString();
    L14:
        return null;
    }
}

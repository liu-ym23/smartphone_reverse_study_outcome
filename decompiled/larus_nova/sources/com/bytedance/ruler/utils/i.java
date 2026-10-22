package com.bytedance.ruler.utils;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class i {
    static {
    }

    public static JSONObject a(JSONObject r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L6;
        return r100;
    L6:
        JSONObject r102 = new JSONObject();
        Iterator<String> r103 = r101.keys();
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        r102.put(r104, r101.get(r104));
        goto L8
    L10:
        Iterator<String> r105 = r100.keys();
    L12:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();
        Object r107 = r100.get(r106);
        if (r102.has(r106) == true) goto L12;
        r102.put(r106, r107);
        goto L12
    L16:
        return r102;
    }
}

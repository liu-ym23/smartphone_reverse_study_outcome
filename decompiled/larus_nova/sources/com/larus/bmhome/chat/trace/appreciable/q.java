package com.larus.bmhome.chat.trace.appreciable;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class q {
    public static final void a(JSONObject r100, CommonParamManager.CommonParam r101) {
        if (r101 == null) goto L16;
        Map<String, String> r102 = r101.getMessageTrackCommonTags();
        if (r102 == null) goto L22;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        if (r100 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L7;
        r100.put(r105, r106);
        goto L7
    L11:
        if (r100.has(r105) == true) goto L13;
        r107 = true;
        goto L14
    L23:
        return;
    L22:
        return;
    }
}

package com.larus.praise.config;

import com.bytedance.common.utility.NetworkClient;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements y57.d {
    public c() {
    }

    @Override // y57.d
    public final String a(String r100, Map r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r102 = new JSONObject();
        HashMap r103 = (HashMap) r101;
        Iterator r104 = r103.keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();
        r102.put(r105, r103.get(r105));
        goto L7
    L9:
        byte[] r106 = r102.toString().getBytes(Charset.forName("UTF-8"));
        return NetworkClient.getDefault().post(r100, r106, false, "application/json", true);
    }
}

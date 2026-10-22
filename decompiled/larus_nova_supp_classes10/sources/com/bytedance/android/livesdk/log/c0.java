package com.bytedance.android.livesdk.log;

import android.util.LruCache;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 {
    public static final LruCache<Long, Long> a = null;

    static {
        a = new LruCache(10);
    }

    public static String a() {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<Long, Long>> r2 = a.snapshot().entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<Long, Long> r3 = r2.next();
        JSONObject r4 = new JSONObject();
        r4.put("gid", String.valueOf(r3.getKey().longValue()));
        r4.put("duration", r3.getValue().longValue());
        r0.put(r4);
        goto L4
    L6:
        r1.put("recent_live_info", r0);
        String r5 = r1.toString();
        if (r5.length() <= 600) goto L11;
        return "";
    L11:
        return r5;
    }
}

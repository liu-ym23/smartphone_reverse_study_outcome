package com.bytedance.ee.bear.lark.announcement;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Map<String, Object> a;
    public final com.bytedance.ee.bear.contract.d b;

    public a(com.bytedance.ee.bear.contract.d r4) {
        this.a = new HashMap();
        this.b = r4;
        HashMap<String, Object> r5 = r4.m("docCommonParams");
        if (r5.isEmpty() == true) goto L8;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, Object> r0 = r6.next();
        this.a.put(r0.getKey(), r0.getValue());
        goto L6
    L10:
        return;
    }

    public final void a(String r4, long r5, long r7) {
        JSONObject r1 = new JSONObject();
        r1.put(TipCallBackData.RESULT, r4);     // Catch: JSONException -> L5
        r1.put("code", r5);     // Catch: JSONException -> L5
        r1.put("startTime", r7);     // Catch: JSONException -> L5
        r1.put("endTime", System.currentTimeMillis());     // Catch: JSONException -> L5
        this.b.u("announce_send_result_dev", r1);     // Catch: JSONException -> L5
        MonitorUtils.monitorEvent("announce_send_result_dev", r1, r1, new JSONObject());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("AnnounceAnalytic", "monitorEvent error " + e);
    }
}

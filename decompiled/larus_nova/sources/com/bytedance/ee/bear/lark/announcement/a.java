package com.bytedance.ee.bear.lark.announcement;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f227243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f227244b;

    public a(com.bytedance.ee.bear.contract.d r100) {
        this.f227243a = new HashMap();
        this.f227244b = r100;
        HashMap<String, Object> r101 = r100.m("docCommonParams");
        if (r101.isEmpty() == true) goto L8;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Object> r103 = r102.next();
        this.f227243a.put(r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }

    public final void a(String r100, long r101, long r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100);     // Catch: JSONException -> L5
        r103.put("code", r101);     // Catch: JSONException -> L5
        r103.put(DyPayConstant.KEY_START_TIME, r102);     // Catch: JSONException -> L5
        r103.put("endTime", System.currentTimeMillis());     // Catch: JSONException -> L5
        this.f227244b.u("announce_send_result_dev", r103);     // Catch: JSONException -> L5
        MonitorUtils.monitorEvent("announce_send_result_dev", r103, r103, new JSONObject());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("AnnounceAnalytic", "monitorEvent error " + e);
    }
}

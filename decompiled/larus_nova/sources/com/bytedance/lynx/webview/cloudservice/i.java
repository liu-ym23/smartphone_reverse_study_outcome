package com.bytedance.lynx.webview.cloudservice;

import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.EventType;
import l17.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class i {
    public static void a(EventType r100, o17.f r101, long r102, long r103) {
        String r104 = r101.f521719a;
        String r105 = r101.f521721c;
        String r106 = r101.f521722d;
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L5
        r107.put("scc_status_code", r104);     // Catch: JSONException -> L5
        r107.put("scc_error_code", r105);     // Catch: JSONException -> L5
        r107.put("scc_error_msg", r106);     // Catch: JSONException -> L5
        r107.put("scc_cost_time", r102);     // Catch: JSONException -> L5
        r107.put("scc_app_start_time", r103);     // Catch: JSONException -> L5
        r107.put("source_context", "native");     // Catch: JSONException -> L5
        EventStatistics.f(r100.getEventCode(), r107);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        k.b(new String[]{"TTSccCloudServiceUtils report cloud service error: " + e});
    }
}

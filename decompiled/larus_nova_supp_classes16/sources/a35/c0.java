package a35;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 {
    public static void a(com.bytedance.ee.bear.contract.d r3, OfflineDoc r4, int r5, int r6) {
        if (r4 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L6
        r0.put("file_id", du5.b.g(r4.getObj_token()));     // Catch: JSONException -> L6
        r0.put("file_type", r4.getType());     // Catch: JSONException -> L6
        r0.put("status", r6);     // Catch: JSONException -> L6
        r0.put("retry_times", r5);     // Catch: JSONException -> L6
        r3.a("dev_performance_sync_status", r0);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.f("SyncReport", e, false);
    }
}

package q48;

import com.bytedance.apm.ApmAgent;
import com.larus.utils.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m implements com.bytedance.android.alog.c {
    public m() {
    }

    @Override // com.bytedance.android.alog.c
    public final void a(String r100, long r101, int r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L7
        r103.put("instance_name", o0.a(r100));     // Catch: JSONException -> L7
        r103.put("delete_type", r102);     // Catch: JSONException -> L7
        long r104 = System.currentTimeMillis();     // Catch: JSONException -> L7
        long r105 = 0;
        if (r101 <= 0) goto L5;
        r105 = r104 - r101;     // Catch: JSONException -> L7
    L5:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L7
        r106.put("max_log_duration", r105 / ((long) 1000));     // Catch: JSONException -> L7
        r106.put("oldest_log_time", r101);     // Catch: JSONException -> L7
        ApmAgent.monitorEvent("alog_retention_time", r103, r106, null);     // Catch: JSONException -> L7
        return;
    }
}

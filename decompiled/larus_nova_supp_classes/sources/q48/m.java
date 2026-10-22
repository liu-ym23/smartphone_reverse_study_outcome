package q48;

import android.util.EventsUtils;
import com.bytedance.android.alog.c;
import com.bytedance.apm.ApmAgent;
import com.larus.utils.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m implements c {
    public m() {
    }

    @Override // com.bytedance.android.alog.c
    public final void a(String r6, long r7, int r9) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("instance_name", o0.a(r6));     // Catch: JSONException -> L7
        r0.put("delete_type", r9);     // Catch: JSONException -> L7
        long r1 = System.currentTimeMillis();     // Catch: JSONException -> L7
        long r3 = 0;
        if (r7 <= 0) goto L5;
        r3 = r1 - r7;     // Catch: JSONException -> L7
    L5:
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L7
        r8.put("max_log_duration", r3 / ((long) EventsUtils.FEAT_TYPE_SHUT_DOWN));     // Catch: JSONException -> L7
        r8.put("oldest_log_time", r7);     // Catch: JSONException -> L7
        ApmAgent.monitorEvent("alog_retention_time", r0, r8, null);     // Catch: JSONException -> L7
        return;
    }
}

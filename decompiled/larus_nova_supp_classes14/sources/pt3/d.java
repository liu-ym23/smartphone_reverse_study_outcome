package pt3;

import com.bytedance.apm.constant.UploadTypeInf;
import nu3.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements c {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ JSONObject b;

    public final String getLogType() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    public final boolean isValid() {
        return true;
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: Exception -> L4
        r0.put("service", "apm_error");     // Catch: Exception -> L4
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L4
        r1.put("type", "large_data");     // Catch: Exception -> L4
        r1.put("error_service", this.a);     // Catch: Exception -> L4
        r1.put("error_log_type", this.b);     // Catch: Exception -> L4
        r0.put("category", r1);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    public d(JSONObject r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}

package lt3;

import com.bytedance.apm.constant.UploadTypeInf;
import nu3.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements c {
    public final JSONArray a;

    public final String getLogType() {
        return UploadTypeInf.TRACING;
    }

    public final boolean isValid() {
        return true;
    }

    public final JSONObject a() {
        JSONArray r1 = this.a;
        JSONObject r2 = new JSONObject().put("wrapper_array_data", r1);     // Catch: Exception -> L5
        r2.put("log_type", UploadTypeInf.TRACING);     // Catch: Exception -> L5
        r2.put("wrapper_type_description", 1);     // Catch: Exception -> L5
        return r2;
    L5:
        return null;
    }

    public d(JSONObject r2) {
        JSONArray r0 = new JSONArray();
        r0.put(r2);
        this.a = r0;
    }

    public d(JSONArray r1) {
        this.a = r1;
    }
}

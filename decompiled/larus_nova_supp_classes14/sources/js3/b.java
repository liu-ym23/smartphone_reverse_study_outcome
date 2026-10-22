package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements hs3.c {
    public final String a;
    public final JSONObject b;
    public JSONObject c;

    public final boolean b() {
        return true;
    }

    public final String d() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    public final String e() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    public final JSONObject a() {
        if (this.c != null) goto L12;
        this.c = new JSONObject();
    L12:
        this.c.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L10
        this.c.put("service", this.a);     // Catch: JSONException -> L10
        this.c.put("status", 0);     // Catch: JSONException -> L10
        JSONObject r0 = this.b;     // Catch: JSONException -> L10
        if (r0 == null) goto L8;
        this.c.put("category", r0);     // Catch: JSONException -> L10
    L8:
        return this.c;
    L10:
        return null;
    }

    public final boolean c(JSONObject r2) {
        String r3 = this.a;
        return zs3.c.a.getServiceSwitch(r3);
    }

    public b(String r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
        this.c = null;
    }
}

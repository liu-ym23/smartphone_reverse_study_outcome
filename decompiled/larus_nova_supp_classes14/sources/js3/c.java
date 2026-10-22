package js3;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements hs3.c {
    public final String a;
    public final JSONObject b;
    public boolean c;
    public final long d;

    public final boolean b() {
        return true;
    }

    public final JSONObject a() {
        JSONObject r0 = this.b;
        if (r0 != null) goto L17;
        return null;
    L17:
        r0.put("timestamp", this.d);     // Catch: JSONException -> L15
        this.b.put("crash_time", this.d);     // Catch: JSONException -> L15
        this.b.put("is_main_process", com.bytedance.apm.d.k());     // Catch: JSONException -> L15
        this.b.put("process_name", com.bytedance.apm.d.c());     // Catch: JSONException -> L15
        this.b.put("log_type", this.a);     // Catch: JSONException -> L15
        if (com.bytedance.apm.d.o > com.bytedance.apm.d.h()) goto L10;
        long r1 = com.bytedance.apm.d.o;     // Catch: JSONException -> L15
        if (r1 == 0) goto L10;
        this.b.put("app_launch_start_time", r1);     // Catch: JSONException -> L15
    L16:
    L10:
        this.b.put("app_launch_start_time", com.bytedance.apm.d.h());     // Catch: JSONException -> L15
    L12:
        return this.b;
    }

    public final String toString() {
        return "ExceptionLogData{eventType='" + this.a + "', logJson=" + this.b + ", forceSampled=" + this.c + ", time=" + this.d + '}';
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.a;
    }

    public final boolean c(JSONObject r1) {
        if (this.c == false) goto L5;
    L8:
        return true;
    L5:
        if (zs3.c.b(this.a) == true) goto L8;
        return false;
    }

    public c(String r3, JSONObject r4) {
        this(r3, r4, System.currentTimeMillis());
    }

    public c(String r1, JSONObject r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
    }
}

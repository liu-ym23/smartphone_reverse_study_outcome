package ss3;

import org.json.JSONException;
import org.json.JSONObject;
import vu3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static volatile e a;

    public static JSONObject a() {
        JSONObject r0 = new JSONObject();
        a r1 = (a) qu3.c.a(a.class);     // Catch: JSONException -> L5
        r0.put("process_usage", r1.getCpuRate());     // Catch: JSONException -> L5
        r0.put("stat_speed", r1.getCpuSpeed());     // Catch: JSONException -> L5
        return r0;
    L6:
        return new JSONObject();
    }

    public static e b() {
        if (a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public e() {
    }
}

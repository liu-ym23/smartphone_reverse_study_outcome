package ss3;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f543346a;

    public static JSONObject a() {
        JSONObject r100 = new JSONObject();
        vu3.a r101 = (vu3.a) qu3.c.a(vu3.a.class);     // Catch: JSONException -> L5
        r100.put("process_usage", r101.getCpuRate());     // Catch: JSONException -> L5
        r100.put("stat_speed", r101.getCpuSpeed());     // Catch: JSONException -> L5
        return r100;
    L6:
        return new JSONObject();
    }

    public static e b() {
        if (f543346a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f543346a != null) goto L9;
        f543346a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f543346a;
    }

    public e() {
    }
}

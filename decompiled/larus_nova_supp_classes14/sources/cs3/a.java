package cs3;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends b {
    public int e;
    public long f;
    public String g;

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.a);     // Catch: Throwable -> L4
        r0.put("end_time", this.b);     // Catch: Throwable -> L4
        r0.put("thread_name", this.c);     // Catch: Throwable -> L4
        r0.put("thread_stack", a());     // Catch: Throwable -> L4
        r0.put("interval", this.f);     // Catch: Throwable -> L4
        r0.put("type", this.e);     // Catch: Throwable -> L4
        r0.put("intent_info", this.g);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public final String toString() {
        return "AlarmInfo{type=" + this.e + ", interval=" + this.f + ", intentInfo=" + this.g + ", startTime=" + this.a + ", endTime=" + this.b + ", threadName=" + this.c + ", threadStack=" + a() + '}';
    }

    public a() {
    }
}

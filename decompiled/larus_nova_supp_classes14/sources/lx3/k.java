package lx3;

import org.json.JSONException;
import org.json.JSONObject;
import rw3.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public long a;
    public String b;
    public boolean c;
    public String d;
    public boolean e;
    public String f;
    public JSONObject g;
    public long h;
    public long i;
    public long j;

    public final String a() {
        JSONObject r0 = new JSONObject();
        r0.put("start_time", this.a);     // Catch: JSONException -> L8
        r0.put("session_id", this.b);     // Catch: JSONException -> L8
        r0.put("is_front_continuous", this.c);     // Catch: JSONException -> L8
        r0.put("front_session_id", this.d);     // Catch: JSONException -> L8
        r0.put("is_end_continuous", this.e);     // Catch: JSONException -> L8
        r0.put("end_session_id", this.f);     // Catch: JSONException -> L8
        r0.put("latest_end_time", this.h);     // Catch: JSONException -> L8
        r0.put("non_task_time", this.i);     // Catch: JSONException -> L8
        r0.put("tea_event_index", this.j);     // Catch: JSONException -> L8
        JSONObject r1 = this.g;     // Catch: JSONException -> L8
        if (r1 == null) goto L6;
        r0.put("flatParams", r1);     // Catch: JSONException -> L8
    L6:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public k() {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.i = 0;
        this.j = 0;
    }

    public final String toString() {
        return a();
    }

    public k(long r3, long r5) {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.i = 0;
        this.j = 0;
        this.a = r3;
        this.b = n.c();
        this.j = r5;
    }
}

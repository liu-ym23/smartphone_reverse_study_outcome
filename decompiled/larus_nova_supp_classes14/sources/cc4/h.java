package cc4;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public long a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;

    public h() {
    }

    public final h a() {
        h r0 = new h();
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        return r0;
    }

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("t", this.a);     // Catch: Exception -> L5
        r0.put("p", this.b);     // Catch: Exception -> L5
        r0.put("x", this.c);     // Catch: Exception -> L5
        r0.put("y", this.d);     // Catch: Exception -> L5
        r0.put("r", this.e);     // Catch: Exception -> L5
        r0.put("f", this.f);     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}

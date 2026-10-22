package yt3;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$b implements Comparable {
    public final String a;
    public final long b;
    public final int c;
    public final /* synthetic */ c d;

    public final String a() {
        String r0 = this.a;
        String r1 = c.a(this.d, r0);
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        if (r0.contains(this.d.a) == false) goto L9;
        return r0.replace(this.d.a, "internal");
    L9:
        if (r0.contains(this.d.c) == true) goto L11;
        return r0;
    L11:
        return r0.replace(this.d.c, "external");
    }

    public JSONObject b() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put("name", a());     // Catch: Exception -> L6
        r0.put("size", this.b);     // Catch: Exception -> L6
        int r1 = this.c;     // Catch: Exception -> L6
        if (r1 <= 0) goto L5;
        r0.put("num", r1);     // Catch: Exception -> L6
    L5:
        return r0;
    L6:
        return null;
    }

    public c$b(c r1) {
        this.d = r1;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r5) {
        long r0 = this.b;
        long r2 = ((c$b) r5).b;
        if (r0 != r2) goto L7;
        return 0;
    L7:
        if (r0 <= r2) goto L10;
        return 1;
    L10:
        return -1;
    }

    public c$b(c r1, String r2, long r3, int r5) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}

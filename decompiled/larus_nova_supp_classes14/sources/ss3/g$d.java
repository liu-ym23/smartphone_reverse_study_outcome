package ss3;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$d extends g$b {
    public final String d;
    public final long e;
    public final int f;
    public final long g;

    @Override // ss3.g$b
    public final JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L13
        String r2 = this.d;     // Catch: Exception -> L13
        if (r2.contains(g.B) == false) goto L6;
        r2 = r2.replace(g.B, "internal");     // Catch: Exception -> L13
    L8:
        r0.put("name", r2);     // Catch: Exception -> L13
        r0.put("size", this.e);     // Catch: Exception -> L13
        int r1 = this.f;     // Catch: Exception -> L13
        if (r1 <= 0) goto L11;
        r0.put("num", r1);     // Catch: Exception -> L13
    L11:
        r0.put("outdate_interval", this.g);     // Catch: Exception -> L13
        return r0;
    L6:
        if (r2.contains(g.C) == false) goto L8;
        r2 = r2.replace(g.C, "external");     // Catch: Exception -> L13
    L13:
        return null;
    }

    @Override // ss3.g$b, java.lang.Comparable
    public final int compareTo(Object r5) {
        long r0 = this.g;
        long r2 = ((g$d) r5).g;
        if (r0 != r2) goto L7;
        return 0;
    L7:
        if (r0 <= r2) goto L10;
        return 1;
    L10:
        return -1;
    }

    public g$d(String r1, long r2, int r4, long r5) {
        this.d = r1;
        this.e = r2;
        this.f = r4;
        this.g = r5;
    }
}

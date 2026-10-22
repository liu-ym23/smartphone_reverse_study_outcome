package ss3;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$b implements Comparable {
    public final String a;
    public final long b;
    public final int c;

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        String r2 = this.a;     // Catch: Exception -> L12
        if (r2.contains(g.B) == false) goto L6;
        r2 = r2.replace(g.B, "internal");     // Catch: Exception -> L12
    L8:
        r0.put("name", r2);     // Catch: Exception -> L12
        r0.put("size", this.b);     // Catch: Exception -> L12
        int r1 = this.c;     // Catch: Exception -> L12
        if (r1 <= 0) goto L11;
        r0.put("num", r1);     // Catch: Exception -> L12
    L11:
        return r0;
    L6:
        if (r2.contains(g.C) == false) goto L8;
        r2 = r2.replace(g.C, "external");     // Catch: Exception -> L12
    L12:
        return null;
    }

    public g$b() {
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r5) {
        long r0 = this.b;
        long r2 = ((g$b) r5).b;
        if (r0 != r2) goto L7;
        return 0;
    L7:
        if (r0 <= r2) goto L10;
        return 1;
    L10:
        return -1;
    }

    public g$b(String r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}

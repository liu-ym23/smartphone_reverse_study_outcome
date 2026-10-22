package cs3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b {
    public long a;
    public long b;
    public String c;
    public StackTraceElement[] d;

    public b() {
    }

    public final String a() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 9;
    L4:
        if (r1 >= this.d.length) goto L7;
        r0.append("\tat ");
        r0.append(this.d[r1].toString());
        r0.append("\n");
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}

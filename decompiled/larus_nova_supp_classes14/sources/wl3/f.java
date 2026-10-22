package wl3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class f {
    public final String a;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public f(String r1) {
        this.a = r1;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof f) == true) goto L5;
        r2 = null;
    L5:
        f r3 = (f) r2;
        if (r3 == null) goto L12;
        String r4 = r3.a;
        if (r4 == null) goto L12;
        if (r4.equals(this.a) != true) goto L12;
        return true;
    L12:
        return false;
    }
}

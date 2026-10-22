package db5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final a[] a;
    public int b;
    public int c;
    public CharSequence d;
    public CharSequence e;

    public static class a {
        public final un5.i a;

        public a(un5.i r1) {
            this.a = r1;
        }
    }

    public final String toString() {
        a[] r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return "CommmentAction [ action = " + this.b + " | start = " + this.c + " | before = " + this.d + " | after = " + this.e + " | spans = " + r1 + " ]";
    L5:
        r1 = r0.length;
        goto L7
    }

    public b(a[] r1, int r2, int r3, CharSequence r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.e = null;
        this.d = r4;
    }
}

package db5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a implements Cloneable {
    public String a;
    public bo4.a[] b;
    public j[] c;
    public k[] d;

    public a() {
        this("", new bo4.a[0], new j[0]);
    }

    public a a() {
        a r1 = (a) super.clone();     // Catch: CloneNotSupportedException -> L17
        bo4.a[] r2 = this.b;     // Catch: CloneNotSupportedException -> L17
        if (r2 == null) goto L9;
        r1.b = (bo4.a[]) r2.clone();     // Catch: CloneNotSupportedException -> L17
        int r3 = 0;
    L6:
        bo4.a[] r4 = this.b;     // Catch: CloneNotSupportedException -> L17
        if (r3 >= r4.length) goto L9;
        r1.b[r3] = r4[r3].a();     // Catch: CloneNotSupportedException -> L17
        r3 = r3 + 1;     // Catch: CloneNotSupportedException -> L17
    L9:
        j[] r5 = this.c;     // Catch: CloneNotSupportedException -> L17
        if (r5 == null) goto L16;
        r1.c = (j[]) r5.clone();     // Catch: CloneNotSupportedException -> L17
        int r6 = 0;
    L12:
        j[] r7 = this.c;     // Catch: CloneNotSupportedException -> L17
        if (r6 >= r7.length) goto L16;
        r1.c[r6] = r7[r6].a();     // Catch: CloneNotSupportedException -> L17
        r6 = r6 + 1;
    L16:
        return r1;
    L17:
        e = move-exception;
        tt5.a.e("AtContent", "colen AtContent failed", e, false);
        return new a();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a(String r2, bo4.a[] r3, j[] r4) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new k[0];
    }
}

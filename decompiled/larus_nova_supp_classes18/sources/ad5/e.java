package ad5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;

    public final String toString() {
        return "HomeTabInfo{id=" + this.a + ", fragmentName='" + this.c + "'}";
    }

    public e(int r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public e(int r1, int r2, String r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.c = "";
    }

    public e(int r1, int r2, int r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.d = "";
        this.c = r5;
        this.e = r3;
        this.f = r4;
    }
}

package k25;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m0 {
    public int a;
    public String b;
    public String c;
    public String d;
    public Long e;
    public Long f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public String t;
    public x25.f u;
    public int v;

    public final boolean a() {
        if (this.q == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b() {
        if (this.q > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String toString() {
        return "ResourceData{id=" + this.a + ", update_time=" + this.e + ", access_time=" + this.f + ", isNeedSync=" + this.g + ", config='" + this.h + "', type='" + this.i + "', dataType='" + this.v + "', subblock_preload_status='" + this.o + "', page=" + this.p + ", totalPage=" + this.q + ", batchNum=" + this.r + ", category=" + this.t + '}';
    }

    public m0() {
        this.e = Long.valueOf(System.currentTimeMillis());
        this.f = Long.valueOf(System.currentTimeMillis());
        this.g = false;
        this.p = 0;
        this.q = 1;
    }

    public String getType() {
        return this.i;
    }

    public m0(m0 r3) {
        this.e = Long.valueOf(System.currentTimeMillis());
        this.f = Long.valueOf(System.currentTimeMillis());
        this.g = false;
        this.p = 0;
        this.q = 1;
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.m = r3.m;
        this.n = r3.n;
        this.v = r3.v;
        this.o = r3.o;
        this.u = r3.u;
        this.p = r3.p;
        this.q = r3.q;
        this.r = r3.r;
        this.s = r3.s;
        this.t = r3.t;
    }

    public m0(String r3, String r4) {
        this.e = Long.valueOf(System.currentTimeMillis());
        this.f = Long.valueOf(System.currentTimeMillis());
        this.g = false;
        this.p = 0;
        this.q = 1;
        this.b = r3;
        this.k = r4;
    }
}

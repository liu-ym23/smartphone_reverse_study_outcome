package k25;

/* JADX INFO: loaded from: classes16.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f501540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f501541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f501542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f501543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f501544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f501545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f501546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f501547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f501548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f501549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f501550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f501551l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f501552m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f501553n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f501554o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f501555p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f501556q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f501557r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f501558s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f501559t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public x25.f f501560u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f501561v;

    public final boolean a() {
        if (this.f501556q == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b() {
        if (this.f501556q > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String toString() {
        return "ResourceData{id=" + this.f501540a + ", update_time=" + this.f501544e + ", access_time=" + this.f501545f + ", isNeedSync=" + this.f501546g + ", config='" + this.f501547h + "', type='" + this.f501548i + "', dataType='" + this.f501561v + "', subblock_preload_status='" + this.f501554o + "', page=" + this.f501555p + ", totalPage=" + this.f501556q + ", batchNum=" + this.f501557r + ", category=" + this.f501559t + '}';
    }

    public m0() {
        this.f501544e = Long.valueOf(System.currentTimeMillis());
        this.f501545f = Long.valueOf(System.currentTimeMillis());
        this.f501546g = false;
        this.f501555p = 0;
        this.f501556q = 1;
    }

    public String getType() {
        return this.f501548i;
    }

    public m0(m0 r100) {
        this.f501544e = Long.valueOf(System.currentTimeMillis());
        this.f501545f = Long.valueOf(System.currentTimeMillis());
        this.f501546g = false;
        this.f501555p = 0;
        this.f501556q = 1;
        this.f501540a = r100.f501540a;
        this.f501541b = r100.f501541b;
        this.f501542c = r100.f501542c;
        this.f501543d = r100.f501543d;
        this.f501544e = r100.f501544e;
        this.f501545f = r100.f501545f;
        this.f501546g = r100.f501546g;
        this.f501547h = r100.f501547h;
        this.f501548i = r100.f501548i;
        this.f501549j = r100.f501549j;
        this.f501550k = r100.f501550k;
        this.f501551l = r100.f501551l;
        this.f501552m = r100.f501552m;
        this.f501553n = r100.f501553n;
        this.f501561v = r100.f501561v;
        this.f501554o = r100.f501554o;
        this.f501560u = r100.f501560u;
        this.f501555p = r100.f501555p;
        this.f501556q = r100.f501556q;
        this.f501557r = r100.f501557r;
        this.f501558s = r100.f501558s;
        this.f501559t = r100.f501559t;
    }

    public m0(String r100, String r101) {
        this.f501544e = Long.valueOf(System.currentTimeMillis());
        this.f501545f = Long.valueOf(System.currentTimeMillis());
        this.f501546g = false;
        this.f501555p = 0;
        this.f501556q = 1;
        this.f501541b = r100;
        this.f501550k = r101;
    }
}

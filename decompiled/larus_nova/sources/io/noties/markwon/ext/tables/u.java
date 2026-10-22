package io.noties.markwon.ext.tables;

/* JADX INFO: loaded from: classes5.dex */
public final class u extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f492557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f492558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f492559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f492560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f492561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f492562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f492563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f492564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f492565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f492566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f492567q;

    public static final class a {
    }

    static {
    }

    public u(t.a r100, int r101, int r102, int r103, int r104, float r105, float r106, float r107, int r108, boolean r110, com.larus.business.markdown.impl.markwon.l r111) {
        super(r100);
        this.f492557g = r101;
        this.f492558h = 0;
        this.f492559i = r102;
        this.f492560j = 0;
        this.f492561k = r105;
        this.f492562l = r106;
        this.f492563m = r107;
        this.f492564n = r108;
        this.f492565o = r110;
        this.f492566p = r111;
        this.f492567q = 1;
        if (r103 >= 0) goto L5;
        r103 = 0;
    L5:
        this.f492555e = r103;
        if (r104 >= 0) goto L8;
        r104 = 0;
    L8:
        this.f492556f = r104;
        if ((r104 * 2) > r102) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Padding(0) can't larger than width(" + r102 + ')');
    }
}

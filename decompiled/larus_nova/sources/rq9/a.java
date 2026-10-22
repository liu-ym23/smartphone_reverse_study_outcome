package rq9;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f538930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f538931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f538932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f538933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f538934e;

    public a() {
        this(null, null, null, null, 31);
    }

    public /* synthetic */ a(d r100, h r110, f r111, gnc.f r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        d r101 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        h r102 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        f r103 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        gnc.f r104 = null;
    L18:
        this(r101, r102, r103, r104, null);
        return;
    L17:
        r104 = r112;
        goto L18
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public a(d r100, h r101, f r102, c r103, g r104) {
        this.f538930a = r100;
        this.f538931b = r101;
        this.f538932c = r102;
        this.f538933d = r103;
        this.f538934e = r104;
    }
}

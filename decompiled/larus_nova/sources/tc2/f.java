package tc2;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f545382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f545383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f545384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f545385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545386e;

    public f() {
        this(null, null, null, null, 0, 31);
    }

    public f(Float r100, Integer r101, Boolean r102, Integer r103, int r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = Float.valueOf(1.0f);
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = Boolean.FALSE;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = -1;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = 0;
    L17:
        this.f545382a = r100;
        this.f545383b = r101;
        this.f545384c = r102;
        this.f545385d = r103;
        this.f545386e = r104;
    }
}

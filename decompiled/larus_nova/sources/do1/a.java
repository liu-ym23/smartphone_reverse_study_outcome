package do1;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f469402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f469403c;

    public a() {
        int r100 = 0;
        this(r100, r100, 7, r100);
    }

    public a(int r100, int r101, int r102) {
        this.f469401a = r100;
        this.f469402b = r101;
        this.f469403c = r102;
    }

    public /* synthetic */ a(int r100, int r101, int r102, int r103) {
        if ((r102 & 1) == 0) goto L5;
        int r104 = -1;
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = -2;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = -1;
    L12:
        this(r104, r100, r101);
        return;
    L5:
        r104 = 0;
        goto L7
    }
}

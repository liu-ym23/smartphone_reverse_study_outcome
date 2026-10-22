package gvc;

/* JADX INFO: loaded from: classes42.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f482998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f482999b;

    public final int a() {
        if ((this.f482998a & 128) != 0) goto L7;
        return 65535;
    L7:
        return this.f482999b[7];
    }

    public s() {
        this.f482999b = new int[10];
    }

    public final void b(int r100, int r101) {
        if (r100 < 0) goto L8;
        int[] r102 = this.f482999b;
        if (r100 >= r102.length) goto L9;
        this.f482998a = (1 << r100) | this.f482998a;
        r102[r100] = r101;
        return;
    L9:
        return;
    }
}

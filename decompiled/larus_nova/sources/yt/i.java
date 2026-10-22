package yt;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f569015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569016b;

    public final int a(float r100) {
        if (r100 > 0) goto L7;
        return this.f569015a;
    L7:
        if (r100 >= 1) goto L9;
        int r101 = this.f569015a;
        return (int) (r101 + ((this.f569016b - r101) * r100));
    L9:
        return this.f569016b;
    }

    public i(int r100, int r101) {
        this.f569015a = r100;
        this.f569016b = r101;
    }
}

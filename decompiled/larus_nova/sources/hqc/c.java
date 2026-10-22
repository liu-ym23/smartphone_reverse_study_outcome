package hqc;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f486843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f486844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f486845c;

    public final void a() {
        int[] r100 = this.f486843a;
        int r101 = r100.length;
        int r102 = this.f486844b;
        int r103 = r101 - r102;
        if (r103 > 2) goto L5;
        int[] r104 = new int[(r100.length + r103) * 2];
        System.arraycopy(r100, 0, r104, 0, r102);
        this.f486843a = r104;
    L5:
        int r105 = this.f486844b;
        int[] r106 = this.f486843a;
        r106[r105] = 0;
        r106[r105 + 1] = 0;
        this.f486844b = r105 + 2;
        this.f486845c++;
    }

    public c() {
        this.f486843a = new int[32];
    }
}

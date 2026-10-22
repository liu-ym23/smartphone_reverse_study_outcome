package db5;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f467808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f467809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f467810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f467811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f467812e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final un5.i f467813a;

        public a(un5.i r100) {
            this.f467813a = r100;
        }
    }

    public final String toString() {
        a[] r100 = this.f467808a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return "CommmentAction [ action = " + this.f467809b + " | start = " + this.f467810c + " | before = " + this.f467811d + " | after = " + this.f467812e + " | spans = " + r101 + " ]";
    L5:
        r101 = r100.length;
        goto L7
    }

    public b(a[] r100, int r101, int r102, CharSequence r103) {
        this.f467808a = r100;
        this.f467809b = r101;
        this.f467810c = r102;
        this.f467812e = null;
        this.f467811d = r103;
    }
}

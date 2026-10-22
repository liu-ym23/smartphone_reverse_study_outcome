package fra;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f478626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f478628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f478629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f478630f;

    public final String toString() {
        return "ReadResult(isSuccess=" + this.f478628d + ", errorMsg='" + this.f478629e + "', readType=" + this.f478630f + ", fromPkg='" + this.f478627c + "', key='" + this.f478625a + "', value='" + this.f478626b + "')";
    }

    public c(String r100, boolean r101, String r102, int r103) {
        this.f478627c = r100;
        this.f478628d = r101;
        this.f478629e = r102;
        this.f478630f = r103;
        this.f478625a = "";
        this.f478626b = "";
    }

    public /* synthetic */ c(String r100, boolean r101, String r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, r102, 0);
    }
}

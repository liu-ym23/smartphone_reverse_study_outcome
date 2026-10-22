package w79;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f558590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f558591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f558592c;

    public a(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = true;
    L8:
        this.f558590a = r100;
        this.f558591b = false;
        this.f558592c = r101;
    }
}

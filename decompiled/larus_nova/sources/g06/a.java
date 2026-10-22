package g06;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f06.a[] f479464k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f479469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f479470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f479471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f479472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f06.a[] f479473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f479474j;

    static {
        f479464k = new f06.a[0];
    }

    public final void b() {
        this.f479472h = null;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f479465a), this.f479466b});
    }

    public final String[] a() {
        return this.f479472h;
    }

    public final void c(f06.a[] r100) {
        this.f479473i = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L17;
        a r101 = (a) r100;
        if (this.f479465a == r101.f479465a) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f479466b, r101.f479466b) == false) goto L15;
        return true;
    }

    public a(int r100, String r101, String[] r102, int r103, String[] r104, String[] r105, String r106) {
        this.f479465a = -1;
        this.f479473i = f479464k;
        this.f479465a = r100;
        this.f479466b = r101;
        this.f479467c = "";
        this.f479468d = "";
        this.f479469e = r102;
        this.f479470f = r103;
        this.f479471g = r104;
        this.f479472h = r105;
        this.f479474j = r106;
    }
}

package wx5;

import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f561820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f561821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f561822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f561823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f561824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f561825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f561826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f561827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String[] f561828i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L31;
        b r101 = (b) r100;
        if (this.f561820a == r101.f561820a) goto L13;
    L29:
        return false;
    L13:
        if (this.f561821b != r101.f561821b) goto L29;
        if (Arrays.equals(this.f561822c, r101.f561822c) == false) goto L29;
        if (Arrays.equals(this.f561823d, r101.f561823d) == false) goto L29;
        if (Arrays.equals(this.f561824e, r101.f561824e) == false) goto L29;
        if (Arrays.equals(this.f561825f, r101.f561825f) == false) goto L29;
        if (Arrays.equals(this.f561826g, r101.f561826g) == false) goto L29;
        if (Arrays.equals(this.f561827h, r101.f561827h) == false) goto L29;
        if (Arrays.equals(this.f561828i, r101.f561828i) == false) goto L29;
        return true;
    }

    public b(boolean r100, boolean r101, String[] r102, String[] r103, String[] r104, String[] r105, String[] r106, String[] r107, String[] r108) {
        this.f561820a = r100;
        this.f561821b = r101;
        this.f561822c = r102;
        this.f561823d = r103;
        this.f561824e = r104;
        this.f561825f = r105;
        this.f561826g = r106;
        this.f561827h = r107;
        this.f561828i = r108;
    }
}

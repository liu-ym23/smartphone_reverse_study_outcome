package z65;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f570495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f570496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f570497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f570498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f570499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f570500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f570501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f570502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f570503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f570504k;

    public final int hashCode() {
        String r100 = this.f570499f;
        int r101 = 0;
        if (r100 == null) goto L5;
        r101 = 0 + r100.hashCode();
    L5:
        String r102 = this.f570500g;
        if (r102 != null) goto L8;
        return r101;
    L8:
        return (r101 * 31) + r102.hashCode();
    }

    public final String toString() {
        return "UploadFileInformation{imageUrl='null', imageId= " + this.f570494a + ", name='" + this.f570495b + "', bytesTransferred='" + this.f570496c + "', bytesTotal='" + this.f570497d + "', status= " + this.f570498e + ", subType= " + this.f570499f + ", itemKey='" + this.f570500g + "', progress= " + this.f570501h + ", lastStatus= " + this.f570502i + ", showSwipeMenu= " + this.f570503j + ", errorCode= " + this.f570504k + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (TextUtils.equals(this.f570499f, r101.f570499f) == true) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(this.f570500g, r101.f570500g) == false) goto L13;
        return true;
    }

    public b(String r100, long r101, long r102, int r103, String r104, String r105, String r106) {
        this.f570495b = r100;
        this.f570496c = r101;
        this.f570497d = r102;
        this.f570498e = r103;
        this.f570499f = r104;
        this.f570500g = r105;
        this.f570504k = r106;
    }
}

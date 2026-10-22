package nfb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f519000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f519001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f519002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f519003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f519004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f519005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f519006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f519007i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f519008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f519009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f519010c;

        public a() {
            this.f519009b = 1;
            this.f519010c = 1;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f518999a, r101.f518999a) == true) goto L12;
        return false;
    L12:
        if (this.f519000b == r101.f519000b) goto L15;
        return false;
    L15:
        if (this.f519001c == r101.f519001c) goto L18;
        return false;
    L18:
        if (this.f519002d == r101.f519002d) goto L21;
        return false;
    L21:
        if (this.f519003e == r101.f519003e) goto L24;
        return false;
    L24:
        if (this.f519004f == r101.f519004f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f519005g, r101.f519005g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f519006h, r101.f519006h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f519007i, r101.f519007i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f518999a.hashCode() * 31;
        long r101 = this.f519000b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f519001c;
        int r104 = (((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f519002d) * 31) + this.f519003e) * 31) + this.f519004f) * 31;
        String r105 = this.f519005g;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f519006h;
        if (r109 != null) goto L9;
        int r110 = 0;
    L10:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f519007i;
        if (r112 == null) goto L15;
        r106 = r112.hashCode();
    L15:
        return r111 + r106;
    L9:
        r110 = r109.hashCode();
        goto L10
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    public final String toString() {
        return "FolderPreviewLoadParams(key=" + this.f518999a + ", start=" + this.f519000b + ", step=" + this.f519001c + ", orderType=" + this.f519002d + ", orderDirection=" + this.f519003e + ", downloadFileScene=" + this.f519004f + ", previewId=" + this.f519005g + ", authFileKey=" + this.f519006h + ", msgLinkToken=" + this.f519007i + ')';
    }

    public b(String r100, long r101, long r102, int r103, int r104, int r105, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518999a = r100;
        this.f519000b = r101;
        this.f519001c = r102;
        this.f519002d = r103;
        this.f519003e = r104;
        this.f519004f = r105;
        this.f519005g = r110;
        this.f519006h = r111;
        this.f519007i = r112;
    }
}

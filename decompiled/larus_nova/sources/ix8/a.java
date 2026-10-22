package ix8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f496378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f496379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f496381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f496382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f496383f;

    public a() {
        this(null, 0.0f, 0, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f496378a, r101.f496378a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f496379b, r101.f496379b) == 0) goto L15;
        return false;
    L15:
        if (this.f496380c == r101.f496380c) goto L18;
        return false;
    L18:
        if (this.f496381d == r101.f496381d) goto L21;
        return false;
    L21:
        if (this.f496382e == r101.f496382e) goto L24;
        return false;
    L24:
        if (this.f496383f == r101.f496383f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f496378a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((r101 * 31) + Float.floatToIntBits(this.f496379b)) * 31) + this.f496380c) * 31;
        int r103 = 1231;
        if (this.f496381d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f496382e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f496383f == true) goto L19;
        r103 = 1237;
    L19:
        return r107 + r103;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VLMIntentDetectConfig(timeoutMs=" + this.f496378a + ", resizeShortSide=" + this.f496379b + ", imageCompressQuality=" + this.f496380c + ", needIntent=" + this.f496381d + ", needDewarp=" + this.f496382e + ", needDetection=" + this.f496383f + ')';
    }

    public /* synthetic */ a(Long r100, float r101, int r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r100 = null;
    L5:
        Long r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        float r103 = 720.0f;
    L10:
        if ((r113 & 4) == 0) goto L12;
        int r104 = 70;
    L14:
        if ((r113 & 8) == 0) goto L16;
        boolean r105 = true;
    L18:
        if ((r113 & 16) == 0) goto L20;
        boolean r106 = false;
    L22:
        if ((r113 & 32) == 0) goto L24;
        boolean r107 = true;
    L25:
        this(r102, r103, r104, r105, r106, r107);
        return;
    L24:
        r107 = r112;
        goto L25
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = false;
        goto L18
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }

    public a(Long r100, float r101, int r102, boolean r103, boolean r104, boolean r105) {
        this.f496378a = r100;
        this.f496379b = r101;
        this.f496380c = r102;
        this.f496381d = r103;
        this.f496382e = r104;
        this.f496383f = r105;
    }
}

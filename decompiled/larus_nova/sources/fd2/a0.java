package fd2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f476463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f476465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f476466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f476467f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L18;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f476462a, r101.f476462a) == true) goto L8;
        return false;
    L8:
        if (this.f476463b == r101.f476463b) goto L10;
        return false;
    L10:
        if (this.f476464c == r101.f476464c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476465d, r101.f476465d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f476466e, r101.f476466e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f476467f, r101.f476467f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f476462a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f476463b;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f476464c) * 31;
        String r105 = this.f476465d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f476466e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f476467f;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        return r110 + r101;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LyricDisplayRequest(url=" + this.f476462a + ", mId=" + this.f476463b + ", lyricType=" + this.f476464c + ", lyricPath=" + this.f476465d + ", startTime=" + this.f476466e + ", endTime=" + this.f476467f + ")";
    }

    public a0(String r100, long r101, int r102, String r103, Long r104, Long r105) {
        this.f476462a = r100;
        this.f476463b = r101;
        this.f476464c = r102;
        this.f476465d = r103;
        this.f476466e = r104;
        this.f476467f = r105;
    }
}

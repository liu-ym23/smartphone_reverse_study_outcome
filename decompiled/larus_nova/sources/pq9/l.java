package pq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f530300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f530301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f530302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f530303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f530304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f530305f;

    public l() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f530300a, r101.f530300a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530301b, r101.f530301b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530302c, r101.f530302c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530303d, r101.f530303d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530304e, r101.f530304e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f530305f, r101.f530305f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f530300a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f530301b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f530302c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f530303d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f530304e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f530305f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoTranscodeParam(transVideoWidth=" + this.f530300a + ", transVideoHeight=" + this.f530301b + ", transVideoFps=" + this.f530302c + ", transVideoBitrate=" + this.f530303d + ", transVideoCodec=" + this.f530304e + ", transVideoType=" + this.f530305f + ')';
    }

    public static l a(l r100, Integer r101, Integer r102, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f530300a;
    L5:
        Integer r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f530301b;
    L8:
        Integer r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        Integer r105 = r100.f530302c;
    L13:
        if ((r111 & 8) == 0) goto L15;
        Long r106 = r100.f530303d;
    L17:
        if ((r111 & 16) == 0) goto L19;
        r110 = r100.f530304e;
    L19:
        String r107 = r110;
        if ((r111 & 32) == 0) goto L22;
        String r108 = r100.f530305f;
    L24:
        return new l(r103, r104, r105, r106, r107, r108);
    L22:
        r108 = null;
        goto L24
    L15:
        r106 = null;
        goto L17
    L11:
        r105 = null;
        goto L13
    }

    public l(Integer r100, Integer r101, Integer r102, Long r103, String r104, String r105) {
        this.f530300a = r100;
        this.f530301b = r101;
        this.f530302c = r102;
        this.f530303d = r103;
        this.f530304e = r104;
        this.f530305f = r105;
    }
}

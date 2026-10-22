package pjc;

import kotlin.jvm.internal.Intrinsics;
import ojc.b;
import rjc.c;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f529533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f529534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f529535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f529536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f529537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final mjc.a f529538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qjc.b f529539g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f529533a, r101.f529533a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529534b, r101.f529534b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f529535c, r101.f529535c) == true) goto L12;
        return false;
    L12:
        if (this.f529536d == r101.f529536d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f529537e, r101.f529537e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f529538f, r101.f529538f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f529539g, r101.f529539g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f529533a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f529534b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f529535c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f529536d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        c r112 = this.f529537e;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        mjc.a r115 = this.f529538f;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        qjc.b r118 = this.f529539g;
        if (r118 == null) goto L26;
        r101 = r118.hashCode();
    L26:
        return r117 + r101;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoClipSegment(startTime=" + this.f529533a + ", duration=" + this.f529534b + ", resource=" + this.f529535c + ", alignOffset=" + this.f529536d + ", sourceStartTime=" + this.f529537e + ", audioConfig=" + this.f529538f + ", videoConfig=" + this.f529539g + ")";
    }

    public a(c r100, c r101, b r102, long r103, c r104, mjc.a r105, qjc.b r110, int r111) {
        if ((r111 & 8) == 0) goto L6;
        r103 = 0;
    L6:
        if ((r111 & 16) == 0) goto L9;
        r104 = c.f538233e;
    L9:
        if ((r111 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r111 & 64) == 0) goto L14;
        r110 = null;
    L14:
        this.f529533a = r100;
        this.f529534b = r101;
        this.f529535c = r102;
        this.f529536d = r103;
        this.f529537e = r104;
        this.f529538f = r105;
        this.f529539g = r110;
    }
}

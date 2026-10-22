package zp9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f573210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f573211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f573212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f573213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f573214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f573215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f573216h;

    public final String toString() {
        return "AvatarDetectResult(faceCount=" + this.f573209a + ", faceClarityScore=" + this.f573210b + ", faceIPAScore=" + this.f573211c + ", faceVerifyRes=" + Arrays.toString(this.f573212d) + ", faceQualityScore=" + this.f573213e + ", faceOcclusionRate=" + this.f573214f + ", faceYaw=" + this.f573215g + ", facePitch=" + this.f573216h + ')';
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f573209a * 31) + Float.floatToIntBits(this.f573210b)) * 31) + Float.floatToIntBits(this.f573211c)) * 31) + Float.floatToIntBits(this.f573213e)) * 31) + Float.floatToIntBits(this.f573214f)) * 31) + Float.floatToIntBits(this.f573215g)) * 31) + Float.floatToIntBits(this.f573216h)) * 31;
        double[] r101 = this.f573212d;
        if (r101 == null) goto L5;
        int r102 = Arrays.hashCode(r101);
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.platform.api.creation.AvatarDetectResult");
        b r102 = (b) r100;
        if (this.f573209a == r102.f573209a) goto L16;
        return false;
    L16:
        if (this.f573210b != r102.f573210b) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == true) goto L22;
        return false;
    L22:
        if (this.f573211c != r102.f573211c) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == true) goto L28;
        return false;
    L28:
        if (this.f573213e != r102.f573213e) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == true) goto L34;
        return false;
    L34:
        if (this.f573214f != r102.f573214f) goto L36;
        boolean r106 = true;
    L37:
        if (r106 == true) goto L40;
        return false;
    L40:
        if (this.f573215g != r102.f573215g) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == true) goto L46;
        return false;
    L46:
        if (this.f573216h != r102.f573216h) goto L48;
        boolean r108 = true;
    L49:
        if (r108 == true) goto L52;
        return false;
    L52:
        if (Arrays.equals(this.f573212d, r102.f573212d) == true) goto L54;
        return false;
    L54:
        return true;
    L48:
        r108 = false;
        goto L49
    L42:
        r107 = false;
        goto L43
    L36:
        r106 = false;
        goto L37
    L30:
        r105 = false;
        goto L31
    L24:
        r104 = false;
        goto L25
    L18:
        r103 = false;
        goto L19
    L8:
        r101 = null;
        goto L10
    }

    public b(int r100, float r101, float r102, double[] r103, float r104, float r105, float r106, float r107) {
        this.f573209a = r100;
        this.f573210b = r101;
        this.f573211c = r102;
        this.f573212d = r103;
        this.f573213e = r104;
        this.f573214f = r105;
        this.f573215g = r106;
        this.f573216h = r107;
    }
}

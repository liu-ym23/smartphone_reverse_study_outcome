package eq2;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f473472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f473475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f473476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f473477f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f473472a, r101.f473472a) == true) goto L8;
        return false;
    L8:
        if (this.f473473b == r101.f473473b) goto L10;
        return false;
    L10:
        if (this.f473474c == r101.f473474c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f473475d, r101.f473475d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f473476e, r101.f473476e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f473477f, r101.f473477f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        PointF r100 = this.f473472a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((((r102 * 31) + this.f473473b) * 31) + this.f473474c) * 31) + Float.floatToIntBits(this.f473475d)) * 31) + Float.floatToIntBits(this.f473476e)) * 31;
        Integer r104 = this.f473477f;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "offset:" + this.f473472a + ",dW:" + this.f473473b + ",dH:" + this.f473474c + ",aW:" + this.f473475d + ",aH:" + this.f473476e;
    }

    public d(PointF r100, int r101, int r102, float r103, float r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "mp4Offset");
        this.f473472a = r100;
        this.f473473b = r101;
        this.f473474c = r102;
        this.f473475d = r103;
        this.f473476e = r104;
        this.f473477f = r105;
    }
}

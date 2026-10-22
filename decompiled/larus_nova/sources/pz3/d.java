package pz3;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f531078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f531079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f531081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f531082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f531083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f531084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f531085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f531086i;

    public d() {
        this(127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Float.compare(this.f531078a, r101.f531078a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f531079b, r101.f531079b) == 0) goto L15;
        return false;
    L15:
        if (this.f531080c == r101.f531080c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f531081d, r101.f531081d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f531082e, r101.f531082e) == true) goto L24;
        return false;
    L24:
        if (this.f531083f == r101.f531083f) goto L27;
        return false;
    L27:
        if (this.f531084g == r101.f531084g) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r100 = ((((Float.floatToIntBits(this.f531078a) * 31) + Float.floatToIntBits(this.f531079b)) * 31) + this.f531080c) * 31;
        View r101 = this.f531081d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        View r105 = this.f531082e;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        boolean r107 = this.f531083f;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f531084g;
        if (r111 == true) goto L18;
        r108 = r111;
    L18:
        return r110 + r108;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoScalingParams(showHeight=" + this.f531078a + ", totalHeight=" + this.f531079b + ", blackCoverHeight=" + this.f531080c + ", videoView=" + this.f531081d + ", coverView=" + this.f531082e + ", onlyTransY=" + this.f531083f + ", scaleVerticalVideo=" + this.f531084g + ')';
    }

    public d(int r100) {
        this.f531078a = 0.0f;
        this.f531079b = 0.0f;
        this.f531080c = 0;
        this.f531081d = null;
        this.f531082e = null;
        this.f531083f = false;
        this.f531084g = false;
        this.f531085h = true;
        this.f531086i = -1;
    }
}

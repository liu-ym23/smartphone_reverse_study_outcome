package rc0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f537026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f537027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f537028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f537029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f537030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f537031f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f537026a, r101.f537026a) == true) goto L8;
        return false;
    L8:
        if (this.f537027b == r101.f537027b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f537028c, r101.f537028c) == true) goto L12;
        return false;
    L12:
        if (this.f537029d == r101.f537029d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f537030e, r101.f537030e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f537031f, r101.f537031f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        RectF r100 = this.f537026a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f537027b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f537028c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f537029d;
        if (r111 == true) goto L17;
        r105 = r111;
    L17:
        int r112 = (r110 + r105) * 31;
        Matrix r113 = this.f537030e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f537031f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExtraStreamRenderData(contentInScreen=" + this.f537026a + ", needBackGround=" + this.f537027b + ", version=" + this.f537028c + ", isPortrait=" + this.f537029d + ", gridMatrix=" + this.f537030e + ", seiRaw=" + this.f537031f + ")";
    }

    public c(RectF r100, boolean r101, Integer r102, boolean r103, Matrix r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "gridMatrix");
        Intrinsics.checkNotNullParameter(r105, "seiRaw");
        this.f537026a = r100;
        this.f537027b = r101;
        this.f537028c = r102;
        this.f537029d = r103;
        this.f537030e = r104;
        this.f537031f = r105;
    }
}

package oq2;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f524850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f524851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f524852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f524853d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f524850a, r101.f524850a) == true) goto L8;
        return false;
    L8:
        if (this.f524851b == r101.f524851b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f524852c, r101.f524852c) == true) goto L12;
        return false;
    L12:
        if (this.f524853d == r101.f524853d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        RectF r100 = this.f524850a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f524851b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f524852c;
        if (r108 == null) goto L12;
        r101 = r108.hashCode();
    L12:
        int r109 = (r107 + r101) * 31;
        boolean r110 = this.f524853d;
        if (r110 == true) goto L17;
        r105 = r110;
    L17:
        return r109 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevStreamRenderData(contentInScreen=" + this.f524850a + ", needBackGround=" + this.f524851b + ", version=" + this.f524852c + ", isPortrait=" + this.f524853d + ")";
    }

    public e(RectF r100, boolean r101, Integer r102, boolean r103) {
        this.f524850a = r100;
        this.f524851b = r101;
        this.f524852c = r102;
        this.f524853d = r103;
    }
}

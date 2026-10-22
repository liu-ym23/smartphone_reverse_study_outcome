package pz3;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public float a;
    public float b;
    public final int c;
    public final View d;
    public final View e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public final int i;

    public d() {
        this(127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
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
        int r0 = ((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31;
        View r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        View r5 = this.e;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.f;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.g;
        if (r11 == true) goto L18;
        r8 = r11;
    L18:
        return r10 + r8;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoScalingParams(showHeight=" + this.a + ", totalHeight=" + this.b + ", blackCoverHeight=" + this.c + ", videoView=" + this.d + ", coverView=" + this.e + ", onlyTransY=" + this.f + ", scaleVerticalVideo=" + this.g + ')';
    }

    public d(int r2) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = -1;
    }
}

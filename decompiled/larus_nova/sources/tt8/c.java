package tt8;

import kotlin.jvm.internal.Intrinsics;
import ut8.f;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f547560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f547561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f547562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f547563d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f547560a == r101.f547560a) goto L12;
        return false;
    L12:
        if (this.f547561b == r101.f547561b) goto L15;
        return false;
    L15:
        if (this.f547562c == r101.f547562c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547563d, r101.f547563d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f547560a * 31) + this.f547561b) * 31;
        if (this.f547562c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        f r103 = this.f547563d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectorRestoreInfo(startCursorPos=" + this.f547560a + ", endCursorPos=" + this.f547561b + ", isTextViewDetachedWithSelector=" + this.f547562c + ", outsideTouchInterceptor=" + this.f547563d + ')';
    }

    public c(int r100, int r101, f r102) {
        this.f547560a = r100;
        this.f547561b = r101;
        this.f547562c = true;
        this.f547563d = r102;
    }
}

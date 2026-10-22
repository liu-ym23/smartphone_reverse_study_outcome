package tx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f547806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f547807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f547808c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f547806a, r101.f547806a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547807b, r101.f547807b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f547808c, r101.f547808c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        RectF r100 = this.f547806a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RectF r104 = this.f547807b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Matrix r107 = this.f547808c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LayoutResult(visibleArea=" + this.f547806a + ", playerArea=" + this.f547807b + ", gridMatrix=" + this.f547808c + ")";
    }

    public a(RectF r100, RectF r101, Matrix r102) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        Intrinsics.checkNotNullParameter(r101, "playerArea");
        Intrinsics.checkNotNullParameter(r102, "gridMatrix");
        this.f547806a = r100;
        this.f547807b = r101;
        this.f547808c = r102;
    }
}

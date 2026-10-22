package g90;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f480466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f480467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f480469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f480470e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f480466a, r101.f480466a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f480467b, r101.f480467b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480468c, r101.f480468c) == true) goto L12;
        return false;
    L12:
        if (this.f480469d == r101.f480469d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f480470e, r101.f480470e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Matrix r100 = this.f480466a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RectF r104 = this.f480467b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f480468c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f480469d) * 31;
        b r110 = this.f480470e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "InteractStatus(gridMatrix=" + this.f480466a + ", visibleArea=" + this.f480467b + ", seiRaw=" + this.f480468c + ", uiLayoutIndex=" + this.f480469d + ", businessData=" + this.f480470e + ")";
    }

    public a(Matrix r100, RectF r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "gridMatrix");
        Intrinsics.checkNotNullParameter(r101, "visibleArea");
        Intrinsics.checkNotNullParameter(r102, "seiRaw");
        this.f480466a = r100;
        this.f480467b = r101;
        this.f480468c = r102;
        this.f480469d = r103;
        this.f480470e = null;
    }
}

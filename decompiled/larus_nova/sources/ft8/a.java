package ft8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f478789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f478790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f478792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f478793e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f478789a, r101.f478789a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478790b, r101.f478790b) == true) goto L15;
        return false;
    L15:
        if (this.f478791c == r101.f478791c) goto L18;
        return false;
    L18:
        if (this.f478792d == r101.f478792d) goto L21;
        return false;
    L21:
        if (this.f478793e == r101.f478793e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f478789a.hashCode() * 31) + this.f478790b.hashCode()) * 31) + this.f478791c) * 31) + this.f478792d) * 31) + this.f478793e;
    }

    public final String toString() {
        return "CropEditOperation(showRect=" + this.f478789a + ", totalRect=" + this.f478790b + ", angle=" + this.f478791c + ", sourceWidth=" + this.f478792d + ", sourceHeight=" + this.f478793e + ')';
    }

    public a(RectF r100, RectF r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "showRect");
        Intrinsics.checkNotNullParameter(r101, "totalRect");
        this.f478789a = r100;
        this.f478790b = r101;
        this.f478791c = r102;
        this.f478792d = r103;
        this.f478793e = r104;
    }
}

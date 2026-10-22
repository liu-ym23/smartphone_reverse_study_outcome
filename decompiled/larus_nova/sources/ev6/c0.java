package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f474283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f474284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f474285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j0 f474286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m0 f474287e;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f474283a, r101.f474283a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474284b, r101.f474284b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474285c, r101.f474285c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474286d, r101.f474286d) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474287e, r101.f474287e) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        k r100 = this.f474283a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a0 r104 = this.f474284b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + 0) * 31;
        d0 r107 = this.f474285c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        j0 r110 = this.f474286d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        m0 r113 = this.f474287e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfProductPriceUIData(finalPrice=" + this.f474283a + ", prefixPrice=" + this.f474284b + ", suffixPrice=null, secondPrice=" + this.f474285c + ", thirdPrice=" + this.f474286d + ", originPrice=" + this.f474287e + ')';
    }

    public c0(int r100) {
        this.f474283a = null;
        this.f474284b = null;
        this.f474285c = null;
        this.f474286d = null;
        this.f474287e = null;
    }

    public final void a(m0 r100) {
        this.f474287e = r100;
    }

    public final void b(a0 r100) {
        this.f474284b = r100;
    }

    public final void c(d0 r100) {
        this.f474285c = r100;
    }

    public final void d(j0 r100) {
        this.f474286d = r100;
    }
}

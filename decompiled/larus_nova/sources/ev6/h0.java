package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f474326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f474327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f474328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Float f474329e;

    public static final class a {
    }

    static {
    }

    public h0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f474325a == r101.f474325a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474326b, r101.f474326b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474327c, r101.f474327c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474328d, r101.f474328d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474329e, r101.f474329e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f474325a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Integer r102 = this.f474326b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f474327c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Float r109 = this.f474328d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Float r112 = this.f474329e;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductTagImgInfoUIData(visible=" + this.f474325a + ", showType=" + this.f474326b + ", imgUrl=" + this.f474327c + ", height=" + this.f474328d + ", width=" + this.f474329e + ')';
    }

    public h0(int r100) {
        this.f474325a = false;
        this.f474326b = null;
        this.f474327c = null;
        this.f474328d = null;
        this.f474329e = null;
    }
}

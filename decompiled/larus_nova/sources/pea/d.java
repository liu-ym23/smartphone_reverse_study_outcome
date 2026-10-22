package pea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f528751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f528753e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f528749a == r101.f528749a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528750b, r101.f528750b) == true) goto L15;
        return false;
    L15:
        if (this.f528751c == r101.f528751c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528752d, r101.f528752d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528753e, r101.f528753e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f528749a * 31) + this.f528750b.hashCode()) * 31) + this.f528751c) * 31;
        String r101 = this.f528752d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f528753e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedAnimIconInfo(type=" + this.f528749a + ", src=" + this.f528750b + ", srcResId=" + this.f528751c + ", srcDark=" + this.f528752d + ", srcDarkResId=" + this.f528753e + ')';
    }

    public final int getType() {
        return this.f528749a;
    }

    public d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        this.f528749a = 0;
        this.f528750b = r100;
        this.f528751c = r101;
        this.f528752d = null;
        this.f528753e = null;
    }
}

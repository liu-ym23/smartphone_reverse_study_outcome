package pea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f528779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f528781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f528782f;

    public static final class a {
    }

    static {
    }

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f528777a == r101.f528777a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528778b, r101.f528778b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528779c, r101.f528779c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528780d, r101.f528780d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528781e, r101.f528781e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528782f, r101.f528782f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528777a * 31;
        String r101 = this.f528778b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f528779c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f528780d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f528781e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        h r114 = this.f528782f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedIdentifyPicInfo(type=" + this.f528777a + ", pic=" + this.f528778b + ", picResId=" + this.f528779c + ", picDark=" + this.f528780d + ", picDarkResId=" + this.f528781e + ", actionInfo=" + this.f528782f + ')';
    }

    public final int getType() {
        return this.f528777a;
    }

    public g(int r100) {
        this.f528777a = 1;
        this.f528778b = null;
        this.f528779c = null;
        this.f528780d = null;
        this.f528781e = null;
        this.f528782f = null;
    }
}

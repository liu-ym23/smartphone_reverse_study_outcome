package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f486563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f486564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f486565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f486566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f486567e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f486563a, r101.f486563a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486564b, r101.f486564b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486565c, r101.f486565c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486566d, r101.f486566d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486567e, r101.f486567e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f486563a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f486564b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486565c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f486566d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f486567e;
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
        return "ActionConfig(iconName=" + this.f486563a + ", darkIconName=" + this.f486564b + ", schema=" + this.f486565c + ", backgroundColor=" + this.f486566d + ", title=" + this.f486567e + ')';
    }

    public d(int r100) {
        this.f486563a = null;
        this.f486564b = null;
        this.f486565c = null;
        this.f486566d = null;
        this.f486567e = null;
    }
}

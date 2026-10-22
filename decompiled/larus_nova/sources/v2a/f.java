package v2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f552738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f552740c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f552738a == r101.f552738a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552739b, r101.f552739b) == true) goto L15;
        return false;
    L15:
        if (this.f552740c == r101.f552740c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f552738a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f552739b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f552740c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MixBarShowStatus(collapsed=" + this.f552738a + ", unfoldMethod=" + this.f552739b + ", fromInit=" + this.f552740c + ')';
    }

    public f(boolean r100, String r101, boolean r102) {
        this.f552738a = r100;
        this.f552739b = r101;
        this.f552740c = r102;
    }
}

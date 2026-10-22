package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f478562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f478563c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L12;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f478561a, r101.f478561a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f478562b, r101.f478562b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f478563c, r101.f478563c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f478561a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f478562b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        y r107 = this.f478563c;
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
        return "IMixedStreamVideoEffectConfig(effectUrl=" + this.f478561a + ", effectPath=" + this.f478562b + ", msg=" + this.f478563c + ")";
    }

    public z() {
        Intrinsics.checkNotNullParameter("", "effectUrl");
        Intrinsics.checkNotNullParameter("", "effectPath");
        this.f478561a = "";
        this.f478562b = "";
        this.f478563c = null;
    }
}

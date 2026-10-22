package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f502575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f502576b;

    public u() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f502575a, r101.f502575a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502576b, r101.f502576b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f502575a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f502576b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DocArtifactConfig(rootBackgroundRes=" + this.f502575a + ", checkDocResourceBackgroundRes=" + this.f502576b + ')';
    }

    public u(Integer r100, Integer r101) {
        this.f502575a = r100;
        this.f502576b = r101;
    }
}

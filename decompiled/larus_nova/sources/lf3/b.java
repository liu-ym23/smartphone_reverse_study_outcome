package lf3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f509051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f509052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f509053d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f509050a, r101.f509050a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509051b, r101.f509051b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509052c, r101.f509052c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509053d, r101.f509053d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509050a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f509051b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f509052c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f509053d;
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
        return "MallRebuildTime(enterFrom=" + this.f509050a + ", rebuildTime=" + this.f509051b + ", rebuildStraightOut=" + this.f509052c + ", rebuildFirstScreen=" + this.f509053d + ")";
    }

    public b(Long r100) {
        this.f509050a = null;
        this.f509051b = r100;
        this.f509052c = null;
        this.f509053d = null;
    }
}

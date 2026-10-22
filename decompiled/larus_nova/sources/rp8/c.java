package rp8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f538876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f538877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f538878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f538879d;

    public c() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f538876a, r101.f538876a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538877b, r101.f538877b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538878c, r101.f538878c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f538879d, r101.f538879d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f538876a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f538877b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f538878c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f538879d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "BottomMenuConfig(cameraVisible=" + this.f538876a + ", albumVisible=" + this.f538877b + ", fileVisible=" + this.f538878c + ", realtimeCallVisible=" + this.f538879d + ')';
    }

    public c(Boolean r100, int r101) {
        if ((r101 & 8) == 0) goto L5;
        r100 = null;
    L5:
        this.f538876a = null;
        this.f538877b = null;
        this.f538878c = null;
        this.f538879d = r100;
    }
}

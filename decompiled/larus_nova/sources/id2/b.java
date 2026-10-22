package id2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ld0.a f489302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489303b;

    public b() {
        this(null, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f489302a, r101.f489302a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f489303b, r101.f489303b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ld0.a r100 = this.f489302a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f489303b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvExitRoomEvent(lastVideoStateSeiData=" + this.f489302a + ", exitRoomSource=" + this.f489303b + ")";
    }

    public b(ld0.a r100, String r101) {
        this.f489302a = r100;
        this.f489303b = r101;
    }
}

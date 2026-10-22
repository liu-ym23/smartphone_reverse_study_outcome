package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478506b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f478505a, r101.f478505a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f478506b, r101.f478506b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f478505a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f478506b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IForwardRoomInfoParam(roomId=" + this.f478505a + ", rtcExtInfo=" + this.f478506b + ")";
    }

    public h(String r100, String r101) {
        this.f478505a = r100;
        this.f478506b = r101;
    }
}

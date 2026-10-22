package ir5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f495472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f495473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f495474c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f495472a, r101.f495472a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495473b, r101.f495473b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495474c, r101.f495474c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f495472a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f495473b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f495474c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeDrivePreviewImageInfo(auditRejected=" + this.f495472a + ", width=" + this.f495473b + ", height=" + this.f495474c + ')';
    }

    public e() {
        this.f495472a = null;
        this.f495473b = null;
        this.f495474c = null;
    }
}

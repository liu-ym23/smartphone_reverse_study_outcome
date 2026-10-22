package lr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f510443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f510444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f510445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f510446d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f510443a == r101.f510443a) goto L12;
        return false;
    L12:
        if (this.f510444b == r101.f510444b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510445c, r101.f510445c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510446d, r101.f510446d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f510443a * 31) + this.f510444b) * 31;
        Boolean r101 = this.f510445c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f510446d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageUplinkUpdateInfo(imgWidth=" + this.f510443a + ", imgHeight=" + this.f510444b + ", isImageMarked=" + this.f510445c + ", isImageCropped=" + this.f510446d + ')';
    }

    public b(int r100, int r101, Boolean r102, Boolean r103) {
        this.f510443a = r100;
        this.f510444b = r101;
        this.f510445c = r102;
        this.f510446d = r103;
    }
}

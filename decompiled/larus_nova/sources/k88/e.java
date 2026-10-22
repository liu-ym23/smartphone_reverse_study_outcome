package k88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502117b;

    public e() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f502116a, r101.f502116a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502117b, r101.f502117b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f502116a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f502117b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarMaterialGalleryExtraInfo(enterFrom=" + this.f502116a + ", replicaCreateId=" + this.f502117b + ')';
    }

    public e(String r100, String r101) {
        this.f502116a = r100;
        this.f502117b = r101;
    }
}

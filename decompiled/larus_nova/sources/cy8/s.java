package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f465908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f465909b;

    public s() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f465908a, r101.f465908a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465909b, r101.f465909b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        m r100 = this.f465908a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m r104 = this.f465909b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasPresetRefImage(imageThumb=" + this.f465908a + ", imageOri=" + this.f465909b + ')';
    }

    public s(m r100, m r101) {
        this.f465908a = r100;
        this.f465909b = r101;
    }
}

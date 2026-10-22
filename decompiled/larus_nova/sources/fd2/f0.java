package fd2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f476492b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L10;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f476491a, r101.f476491a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476492b, r101.f476492b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f476491a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f476492b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreviewMvInfo(coverUrl=" + this.f476491a + ", videoUrl=" + this.f476492b + ")";
    }

    public f0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "videoUrl");
        this.f476491a = r100;
        this.f476492b = r101;
    }
}

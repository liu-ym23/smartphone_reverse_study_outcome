package tf1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f545706b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f545705a, r101.f545705a) == true) goto L8;
        return false;
    L8:
        if (this.f545706b == r101.f545706b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f545705a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f545706b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicBorderModel(filePath=" + this.f545705a + ", duration=" + this.f545706b + ")";
    }

    public a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f545705a = r100;
        this.f545706b = r101;
    }
}

package tx9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f547915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547916b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (this.f547915a == r101.f547915a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547916b, r101.f547916b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f547915a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f547916b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "DownloadFileInfo(fileSize=" + this.f547915a + ", fileFormat=" + this.f547916b + ')';
    }

    public y0(long r100, String r101) {
        this.f547915a = r100;
        this.f547916b = r101;
    }
}

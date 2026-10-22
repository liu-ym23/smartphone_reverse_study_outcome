package zn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f573005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f573006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f573007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f573008d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f573005a, r101.f573005a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573006b, r101.f573006b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573007c, r101.f573007c) == true) goto L18;
        return false;
    L18:
        if (this.f573008d == r101.f573008d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f573005a.hashCode() * 31) + this.f573006b.hashCode()) * 31) + this.f573007c.hashCode()) * 31;
        if (this.f573008d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VideoGroupViewInput(sizeData=" + this.f573005a + ", videoData=" + this.f573006b + ", trackData=" + this.f573007c + ", isOversea=" + this.f573008d + ')';
    }

    public r(l r100, q r101, p r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "sizeData");
        Intrinsics.checkNotNullParameter(r101, "videoData");
        Intrinsics.checkNotNullParameter(r102, "trackData");
        this.f573005a = r100;
        this.f573006b = r101;
        this.f573007c = r102;
        this.f573008d = r103;
    }
}

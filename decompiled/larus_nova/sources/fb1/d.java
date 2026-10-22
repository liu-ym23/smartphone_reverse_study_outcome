package fb1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f476248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f476249b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f476248a, r101.f476248a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476249b, r101.f476249b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        b r100 = this.f476248a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f476249b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SourceCompositionModel(songSourceModel=" + this.f476248a + ", videoSourceModel=" + this.f476249b + ")";
    }

    public d(b r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "songSourceModel");
        Intrinsics.checkNotNullParameter(r101, "videoSourceModel");
        this.f476248a = r100;
        this.f476249b = r101;
    }
}

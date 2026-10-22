package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486781c;

    public u() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f486779a == r101.f486779a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486780b, r101.f486780b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486781c, r101.f486781c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f486779a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f486780b.hashCode()) * 31) + this.f486781c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "AudioThemeConfigModel(bigVideoEnable=" + this.f486779a + ", ballBigVideoUrl=" + this.f486780b + ", ballBigVideoChannel=" + this.f486781c + ')';
    }

    public /* synthetic */ u(int r100) {
        this(false, "", "");
    }

    public u(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "ballBigVideoUrl");
        Intrinsics.checkNotNullParameter(r102, "ballBigVideoChannel");
        this.f486779a = r100;
        this.f486780b = r101;
        this.f486781c = r102;
    }
}

package yw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f569337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f569338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f569339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f569340d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f569337a == r101.f569337a) goto L12;
        return false;
    L12:
        if (this.f569338b == r101.f569338b) goto L15;
        return false;
    L15:
        if (this.f569339c == r101.f569339c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569340d, r101.f569340d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f569337a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f569338b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.f569339c) * 31;
        e r104 = this.f569340d;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CollectResult(success=" + this.f569337a + ", toCollect=" + this.f569338b + ", from=" + this.f569339c + ", originResponse=" + this.f569340d + ')';
    }

    public f(boolean r100, boolean r101, int r102, e r103) {
        this.f569337a = r100;
        this.f569338b = r101;
        this.f569339c = r102;
        this.f569340d = r103;
    }
}

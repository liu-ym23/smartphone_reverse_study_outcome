package lw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f511088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f511089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f511090c;

    public m() {
        Long r100 = null;
        this(r100, r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f511088a, r101.f511088a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511089b, r101.f511089b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511090c, r101.f511090c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f511088a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f511089b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f511090c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarkwonPerformance(markwonCreateDuration=" + this.f511088a + ", markwonParseDuration=" + this.f511089b + ", markwonRenderDuration=" + this.f511090c + ')';
    }

    public m(Long r100, Long r101, Long r102) {
        this.f511088a = r100;
        this.f511089b = r101;
        this.f511090c = r102;
    }

    public /* synthetic */ m(Long r100, Long r101, Long r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

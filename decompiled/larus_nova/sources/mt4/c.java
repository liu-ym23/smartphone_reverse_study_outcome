package mt4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f515635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515636b;

    public final int hashCode() {
        return (this.f515635a * 31) + this.f515636b;
    }

    public final String toString() {
        return "Position(index=" + this.f515635a + ", offset=" + this.f515636b + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(c.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.Position");
        c r102 = (c) r100;
        if (this.f515635a == r102.f515635a) goto L16;
        return false;
    L16:
        if (this.f515636b == r102.f515636b) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public c(int r100, int r101) {
        this.f515635a = r100;
        this.f515636b = r101;
    }
}

package kc8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f502537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f502538b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (this.f502537a == r101.f502537a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502538b, r101.f502538b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502537a * 31) + this.f502538b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockRenderConfig(maxContentWidth=" + this.f502537a + ", onCoverLongClick=" + this.f502538b + ')';
    }

    public o0(int r100, cb8.r r101) {
        Intrinsics.checkNotNullParameter(r101, "onCoverLongClick");
        this.f502537a = r100;
        this.f502538b = r101;
    }
}

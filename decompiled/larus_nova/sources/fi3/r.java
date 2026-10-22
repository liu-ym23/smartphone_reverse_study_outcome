package fi3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477309a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477309a, ((r) r100).f477309a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f477309a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PDPJumpToBuyerShowWaterfallPageParam(productId=" + this.f477309a + ")";
    }

    public r(String r100) {
        this.f477309a = r100;
    }
}

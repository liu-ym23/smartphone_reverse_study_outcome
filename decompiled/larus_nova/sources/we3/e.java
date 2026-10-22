package we3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f559393a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f559393a, ((e) r100).f559393a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f559393a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveListProductInfo(promotionId=" + this.f559393a + ")";
    }

    public e(Long r100) {
        this.f559393a = r100;
    }
}

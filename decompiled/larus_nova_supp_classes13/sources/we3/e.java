package we3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final Long a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "LiveListProductInfo(promotionId=" + this.a + ")";
    }

    public e(Long r1) {
        this.a = r1;
    }
}

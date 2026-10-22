package vg3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l0 {
    public final String a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l0) == false) goto L10;
        l0 r4 = (l0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "PdpBottomOverlayInset(source=" + this.a + ", heightPx=" + this.b + ")";
    }

    public l0(int r3) {
        Intrinsics.checkNotNullParameter("pdp_ai_chat", "source");
        this.a = "pdp_ai_chat";
        this.b = r3;
    }
}

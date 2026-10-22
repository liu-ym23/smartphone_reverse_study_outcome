package ud3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final String a;
    public final String b;
    public final int c;

    public h() {
        this(null, null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L12;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.c;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportCpsTrackRequest(productId=" + this.a + ", cpsTrack=" + this.b + ", reportType=" + this.c + ")";
    }

    public h(String r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        int r6 = 1;
    L12:
        this.a = r3;
        this.b = r4;
        this.c = r6;
        return;
    L11:
        r6 = 0;
        goto L12
    }
}

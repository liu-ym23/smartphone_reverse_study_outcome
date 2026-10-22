package si2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public final String a;
    public final boolean b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L12;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return ((r2 + r4) * 31) + this.c;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ECPromotionListToastContent(content=" + this.a + ", explainSamePromotion=" + this.b + ", msgType=" + this.c + ")";
    }

    public /* synthetic */ m(String r3) {
        this(r3, false, -1);
    }

    public m(String r1, boolean r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

package si2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f542186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542187c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f542185a, r101.f542185a) == true) goto L8;
        return false;
    L8:
        if (this.f542186b == r101.f542186b) goto L10;
        return false;
    L10:
        if (this.f542187c == r101.f542187c) goto L19;
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
        String r100 = this.f542185a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f542186b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return ((r102 + r104) * 31) + this.f542187c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ECPromotionListToastContent(content=" + this.f542185a + ", explainSamePromotion=" + this.f542186b + ", msgType=" + this.f542187c + ")";
    }

    public /* synthetic */ m(String r100) {
        this(r100, false, -1);
    }

    public m(String r100, boolean r101, int r102) {
        this.f542185a = r100;
        this.f542186b = r101;
        this.f542187c = r102;
    }
}

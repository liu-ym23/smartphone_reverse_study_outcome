package mi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f514034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514035b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f514034a == r101.f514034a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f514035b, r101.f514035b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f514034a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f514035b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "CollectionChangedEvent(isFavoured=" + this.f514034a + ", itemId=" + this.f514035b + ")";
    }

    public a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        this.f514034a = r100;
        this.f514035b = r101;
    }
}

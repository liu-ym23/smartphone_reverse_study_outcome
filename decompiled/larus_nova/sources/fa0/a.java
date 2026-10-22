package fa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f475995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475996c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f475994a == r101.f475994a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475995b, r101.f475995b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475996c, r101.f475996c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f475994a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.f475995b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f475996c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GroupContainerBusinessState(isRunning=" + this.f475994a + ", type=" + this.f475995b + ", currentPayload=" + this.f475996c + ")";
    }

    public final Integer getType() {
        return this.f475995b;
    }

    public /* synthetic */ a(int r100) {
        this(false, null, null);
    }

    public a(boolean r100, Integer r101, String r102) {
        this.f475994a = r100;
        this.f475995b = r101;
        this.f475996c = r102;
    }
}

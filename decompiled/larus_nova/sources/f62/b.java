package f62;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s22.a f475688c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f475686a == r101.f475686a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475687b, r101.f475687b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475688c, r101.f475688c) == true) goto L19;
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
        boolean r100 = this.f475686a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f475687b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        s22.a r107 = this.f475688c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ChatChannelShowInviteEvent(isAuto=" + this.f475686a + ", toast=" + this.f475687b + ", chatChannel=" + this.f475688c + ")";
    }

    public b(boolean r100, String r101, s22.a r102) {
        Intrinsics.checkNotNullParameter(r102, "chatChannel");
        this.f475686a = r100;
        this.f475687b = r101;
        this.f475688c = r102;
    }
}

package lo0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f510084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f510086d;

    public b() {
        this(null, false, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f510083a, r101.f510083a) == true) goto L8;
        return false;
    L8:
        if (this.f510084b == r101.f510084b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f510085c, r101.f510085c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510086d, r101.f510086d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f510083a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f510084b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f510085c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f510086d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PrivateMsgTabInfo(tabText=" + this.f510083a + ", isEnable=" + this.f510084b + ", tabDesc=" + this.f510085c + ", settingDesc=" + this.f510086d + ")";
    }

    public b(String r100, boolean r101, String r102, String r103) {
        this.f510083a = r100;
        this.f510084b = r101;
        this.f510085c = r102;
        this.f510086d = r103;
    }
}

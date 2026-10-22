package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f571906d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f571903a, r101.f571903a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571904b, r101.f571904b) == true) goto L10;
        return false;
    L10:
        if (this.f571905c == r101.f571905c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571906d, r101.f571906d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f571903a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571904b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f571905c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        q r110 = this.f571906d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ChangeStickerEventV2(panel=" + this.f571903a + ", effectID=" + this.f571904b + ", use=" + this.f571905c + ", listener=" + this.f571906d + ")";
    }

    public p(String r100, String r101, boolean r102, q r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "effectID");
        this.f571903a = r100;
        this.f571904b = r101;
        this.f571905c = r102;
        this.f571906d = r103;
    }
}

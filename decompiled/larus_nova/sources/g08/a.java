package g08;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f479501c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f479499a, r101.f479499a) == true) goto L12;
        return false;
    L12:
        if (this.f479500b == r101.f479500b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479501c, r101.f479501c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f479499a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f479500b) * 31;
        Integer r104 = this.f479501c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkTagDataItem(text=" + this.f479499a + ", tagType=" + this.f479500b + ", priority=" + this.f479501c + ')';
    }

    public a(String r100, int r101, Integer r102) {
        this.f479499a = r100;
        this.f479500b = r101;
        this.f479501c = r102;
    }
}

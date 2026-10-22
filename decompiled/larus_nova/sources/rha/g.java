package rha;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f537824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537826c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f537824a == r101.f537824a) goto L12;
        return false;
    L12:
        if (this.f537825b == r101.f537825b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537826c, r101.f537826c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f537824a * 31) + this.f537825b) * 31) + this.f537826c.hashCode();
    }

    public final String toString() {
        return "SecondaryMenuItemInfo(id=" + this.f537824a + ", imageSrc=" + this.f537825b + ", title=" + this.f537826c + ')';
    }

    public g(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f537824a = r100;
        this.f537825b = r101;
        this.f537826c = r102;
    }
}

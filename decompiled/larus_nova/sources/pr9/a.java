package pr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f530387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f530388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f530389d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f530386a, r101.f530386a) == true) goto L12;
        return false;
    L12:
        if (this.f530387b == r101.f530387b) goto L15;
        return false;
    L15:
        if (this.f530388c == r101.f530388c) goto L18;
        return false;
    L18:
        if (this.f530389d == r101.f530389d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f530386a.hashCode() * 31;
        int r101 = 1231;
        if (this.f530387b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f530388c) * 31;
        if (this.f530389d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CustomAosExportPreloadModel(aid=" + this.f530386a + ", needCachePicture=" + this.f530387b + ", priority=" + this.f530388c + ", preloadVideoData=" + this.f530389d + ')';
    }

    public a(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "aid");
        this.f530386a = r100;
        this.f530387b = r101;
        this.f530388c = 0;
        this.f530389d = false;
    }
}

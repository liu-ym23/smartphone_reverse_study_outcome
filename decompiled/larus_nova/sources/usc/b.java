package usc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f551568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f551569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f551571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f551572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f551573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f551574g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L28:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L27;
        b r101 = (b) r100;
        if (this.f551568a != r101.f551568a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        if (this.f551569b != r101.f551569b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L27;
        if (Intrinsics.areEqual(this.f551570c, r101.f551570c) == false) goto L27;
        if (Intrinsics.areEqual(this.f551571d, r101.f551571d) == false) goto L27;
        if (Intrinsics.areEqual(this.f551572e, r101.f551572e) == false) goto L27;
        if (Intrinsics.areEqual(this.f551573f, r101.f551573f) == false) goto L27;
        if (Intrinsics.areEqual(this.f551574g, r101.f551574g) == false) goto L27;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L27:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f551568a * 31) + this.f551569b) * 31;
        String r101 = this.f551570c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f551571d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f551572e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f551573f;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        f r114 = this.f551574g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CachedWidget(startIndex=" + this.f551568a + ", endIndex=" + this.f551569b + ", dataType=" + this.f551570c + ", dataValue=" + this.f551571d + ", dataValueId=" + this.f551572e + ", dataTag=" + this.f551573f + ", widget=" + this.f551574g + ")";
    }

    public b(int r100, int r101, String r102, String r103, String r104, String r105, f r106) {
        this.f551568a = r100;
        this.f551569b = r101;
        this.f551570c = r102;
        this.f551571d = r103;
        this.f551572e = r104;
        this.f551573f = r105;
        this.f551574g = r106;
    }
}

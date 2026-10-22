package gr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f482404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f482405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f482406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f482407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f482408g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f482402a, r101.f482402a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f482403b, r101.f482403b) == true) goto L15;
        return false;
    L15:
        if (this.f482404c == r101.f482404c) goto L18;
        return false;
    L18:
        if (this.f482405d == r101.f482405d) goto L21;
        return false;
    L21:
        if (this.f482406e == r101.f482406e) goto L24;
        return false;
    L24:
        if (this.f482407f == r101.f482407f) goto L27;
        return false;
    L27:
        if (this.f482408g == r101.f482408g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f482402a.hashCode() * 31) + this.f482403b.hashCode()) * 31;
        long r101 = this.f482404c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f482405d;
        int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f482406e) * 31) + this.f482407f) * 31;
        if (this.f482408g == false) goto L5;
        int r105 = 1231;
    L7:
        return r104 + r105;
    L5:
        r105 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubConversationSimplifyModel(id=" + this.f482402a + ", title=" + this.f482403b + ", updateTime=" + this.f482404c + ", version=" + this.f482405d + ", badgeCount=" + this.f482406e + ", readBadgeCount=" + this.f482407f + ", isMainConversation=" + this.f482408g + ')';
    }

    public b(String r100, String r101, long r102, long r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f482402a = r100;
        this.f482403b = r101;
        this.f482404c = r102;
        this.f482405d = r103;
        this.f482406e = r104;
        this.f482407f = r105;
        this.f482408g = false;
    }
}

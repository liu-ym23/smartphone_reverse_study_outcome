package hy9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f487637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f487639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f487640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f487641e;

    public b() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f487637a == r101.f487637a) goto L12;
        return false;
    L12:
        if (this.f487638b == r101.f487638b) goto L15;
        return false;
    L15:
        if (this.f487639c == r101.f487639c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487640d, r101.f487640d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487641e, r101.f487641e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f487637a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f487638b) * 31;
        if (this.f487639c == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        g r104 = this.f487640d;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        Long r108 = this.f487641e;
        if (r108 == null) goto L19;
        r105 = r108.hashCode();
    L19:
        return r107 + r105;
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HostReadState(eligible=" + this.f487637a + ", roundNum=" + this.f487638b + ", isHostRead=" + this.f487639c + ", roundInfo=" + this.f487640d + ", curServerTimeMs=" + this.f487641e + ')';
    }

    public /* synthetic */ b(Long r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        int r102 = -1;
    L7:
        if ((r101 & 16) == 0) goto L9;
        r100 = null;
    L9:
        this(false, r102, false, null, r100);
        return;
    L5:
        r102 = 0;
        goto L7
    }

    public b(boolean r100, int r101, boolean r102, g r103, Long r104) {
        this.f487637a = r100;
        this.f487638b = r101;
        this.f487639c = r102;
        this.f487640d = r103;
        this.f487641e = r104;
    }
}

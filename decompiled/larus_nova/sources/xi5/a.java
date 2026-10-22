package xi5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f563950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f563951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f563952e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f563948a, r101.f563948a) == true) goto L12;
        return false;
    L12:
        if (this.f563949b == r101.f563949b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f563950c, r101.f563950c) == true) goto L18;
        return false;
    L18:
        if (this.f563951d == r101.f563951d) goto L21;
        return false;
    L21:
        if (this.f563952e == r101.f563952e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f563948a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f563949b) * 31;
        String r104 = this.f563950c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f563951d) * 31;
        if (this.f563952e == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BuildUrlParams(token=" + this.f563948a + ", type=" + this.f563949b + ", pageToken=" + this.f563950c + ", pageSize=" + this.f563951d + ", isStart=" + this.f563952e + ')';
    }

    public final int getType() {
        return this.f563949b;
    }

    public a(String r100, int r101, String r102, int r103, boolean r104) {
        this.f563948a = r100;
        this.f563949b = r101;
        this.f563950c = r102;
        this.f563951d = r103;
        this.f563952e = r104;
    }
}

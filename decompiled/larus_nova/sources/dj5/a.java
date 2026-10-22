package dj5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f468948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f468949e;

    public a() {
        String r100 = null;
        this(r100, r100, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468945a, r101.f468945a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468946b, r101.f468946b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468947c, r101.f468947c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468948d, r101.f468948d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f468949e, r101.f468949e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f468945a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f468946b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f468947c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f468948d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f468949e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AuditWikiInfo(wikiToken=" + this.f468945a + ", wikiId=" + this.f468946b + ", type=" + this.f468947c + ", spaceName=" + this.f468948d + ", url=" + this.f468949e + ')';
    }

    public final String getType() {
        return this.f468947c;
    }

    public /* synthetic */ a(String r100, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        this(r101, r102, r103, null, null);
        return;
    L13:
        r103 = r111;
        goto L14
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        this.f468945a = r100;
        this.f468946b = r101;
        this.f468947c = r102;
        this.f468948d = r103;
        this.f468949e = r104;
    }
}

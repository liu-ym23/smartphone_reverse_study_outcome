package wb5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f558995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f558999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f559000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f559001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f559002h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f558995a == r101.f558995a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558996b, r101.f558996b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558997c, r101.f558997c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558998d, r101.f558998d) == true) goto L21;
        return false;
    L21:
        if (this.f558999e == r101.f558999e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f559000f, r101.f559000f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f559001g, r101.f559001g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f559002h, r101.f559002h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.f558995a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((((((((r100 * 31) + this.f558996b.hashCode()) * 31) + this.f558997c.hashCode()) * 31) + this.f558998d.hashCode()) * 31) + this.f558999e) * 31) + this.f559000f.hashCode()) * 31) + this.f559001g.hashCode()) * 31) + this.f559002h.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MainNavParams(isInDocOrDrive=" + this.f558995a + ", appId=" + this.f558996b + ", title=" + this.f558997c + ", url=" + this.f558998d + ", type=" + this.f558999e + ", subType=" + this.f559000f + ", objToken=" + this.f559001g + ", token=" + this.f559002h + ')';
    }

    public final int getType() {
        return this.f558999e;
    }

    public /* synthetic */ d(String r110, String r111, String r112, int r113, String r114) {
        this(false, r110, r111, r112, r113, r114, "", "");
    }

    public d(boolean r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r105, "subType");
        Intrinsics.checkNotNullParameter(r106, "objToken");
        Intrinsics.checkNotNullParameter(r107, "token");
        this.f558995a = r100;
        this.f558996b = r101;
        this.f558997c = r102;
        this.f558998d = r103;
        this.f558999e = r104;
        this.f559000f = r105;
        this.f559001g = r106;
        this.f559002h = r107;
    }
}

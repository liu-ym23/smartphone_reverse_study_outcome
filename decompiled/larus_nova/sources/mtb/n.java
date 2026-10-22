package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f515695f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f515696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f515698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f515700e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f515696a == r101.f515696a) goto L12;
        return false;
    L12:
        if (this.f515697b == r101.f515697b) goto L15;
        return false;
    L15:
        if (this.f515698c == r101.f515698c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515699d, r101.f515699d) == true) goto L21;
        return false;
    L21:
        if (this.f515700e == r101.f515700e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f515696a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f515697b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f515698c;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f515699d.hashCode()) * 31;
        if (this.f515700e == true) goto L15;
        r100 = 1237;
    L15:
        return r106 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeUserRelation(isFriend=" + this.f515696a + ", requestUserApply=" + this.f515697b + ", requestUserApplyId=" + this.f515698c + ", requestUserApplyReason=" + this.f515699d + ", targetUserApply=" + this.f515700e + ')';
    }

    public n(boolean r100, boolean r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "requestUserApplyReason");
        this.f515696a = r100;
        this.f515697b = r101;
        this.f515698c = r102;
        this.f515699d = r103;
        this.f515700e = r104;
    }
}

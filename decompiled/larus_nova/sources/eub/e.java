package eub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f474148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f474149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f474152e;

    public e() {
        this(null, null, null, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f474148a, r101.f474148a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474149b, r101.f474149b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474150c, r101.f474150c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474151d, r101.f474151d) == true) goto L21;
        return false;
    L21:
        if (this.f474152e == r101.f474152e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f474148a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f474149b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f474150c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f474151d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.f474152e;
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
        return "MmMinutesFileUploadQuotaInfo(hasQuota=" + this.f474148a + ", isAdmin=" + this.f474149b + ", noQuotaNotice=" + this.f474150c + ", billUrl=" + this.f474151d + ", denyType=" + this.f474152e + ')';
    }

    public e(Boolean r100, Boolean r101, String r102, String r103, int r104) {
        this.f474148a = r100;
        this.f474149b = r101;
        this.f474150c = r102;
        this.f474151d = r103;
        this.f474152e = r104;
    }
}

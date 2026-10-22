package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f479218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f479219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkerInviteContent f479222g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L20;
        i r101 = (i) r100;
        if (this.f479216a == r101.f479216a) goto L8;
        return false;
    L8:
        if (this.f479217b == r101.f479217b) goto L10;
        return false;
    L10:
        if (this.f479218c == r101.f479218c) goto L12;
        return false;
    L12:
        if (this.f479219d == r101.f479219d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479220e, r101.f479220e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f479221f, r101.f479221f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479222g, r101.f479222g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f479216a * 31;
        long r101 = this.f479217b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f479218c) * 31;
        long r103 = this.f479219d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f479220e;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f479221f;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        LinkerInviteContent r112 = this.f479222g;
        if (r112 == null) goto L14;
        r106 = r112.hashCode();
    L14:
        return r111 + r106;
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "PermitParams(scene=" + this.f479216a + ", channelId=" + this.f479217b + ", permitStatus=" + this.f479218c + ", roomId=" + this.f479219d + ", applyUserId=" + this.f479220e + ", applyAnchorSecId=" + this.f479221f + ", applyContent=" + this.f479222g + ")";
    }

    public i(int r100, long r101, int r102, long r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "applyUserId");
        this.f479216a = r100;
        this.f479217b = r101;
        this.f479218c = r102;
        this.f479219d = r103;
        this.f479220e = r104;
        this.f479221f = r105;
        this.f479222g = null;
    }
}

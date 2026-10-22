package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f468144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f468145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f468146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f468147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f468148h;

    public q() {
        this(null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L22;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f468141a, r101.f468141a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468142b, r101.f468142b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468143c, r101.f468143c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468144d, r101.f468144d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f468145e, r101.f468145e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468146f, r101.f468146f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468147g, r101.f468147g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f468148h, r101.f468148h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468141a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f468142b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f468143c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f468144d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f468145e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f468146f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f468147g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f468148h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPPassThough(whichAccount=" + this.f468141a + ", recommendInfo=" + this.f468142b + ", requestId=" + this.f468143c + ", labelNameFromLive=" + this.f468144d + ", baseVerifiedCategory=" + this.f468145e + ", labelNameLive=" + this.f468146f + ", transitionTrackerData=" + this.f468147g + ", threeDLogData=" + this.f468148h + ")";
    }

    public /* synthetic */ q(String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r110 = null;
    L6:
        if ((r114 & 16) == 0) goto L8;
        String r100 = null;
    L10:
        if ((r114 & 32) == 0) goto L12;
        String r101 = null;
    L14:
        if ((r114 & 128) == 0) goto L16;
        String r102 = null;
    L17:
        this(null, null, null, r110, r100, r101, null, r102);
        return;
    L16:
        r102 = r113;
        goto L17
    L12:
        r101 = r112;
        goto L14
    L8:
        r100 = r111;
        goto L10
    }

    public q(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.f468141a = r100;
        this.f468142b = r101;
        this.f468143c = r102;
        this.f468144d = r103;
        this.f468145e = r104;
        this.f468146f = r105;
        this.f468147g = r106;
        this.f468148h = r107;
    }
}

package z29;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MembershipQuotaRowKind f569803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f569805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f569806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f569807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MembershipQuotaBarTier f569808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f569809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f569810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f569811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f569812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f569813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f569814l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f569803a == r101.f569803a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569804b, r101.f569804b) == true) goto L15;
        return false;
    L15:
        if (this.f569805c == r101.f569805c) goto L18;
        return false;
    L18:
        if (Double.compare(this.f569806d, r101.f569806d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f569807e, r101.f569807e) == 0) goto L24;
        return false;
    L24:
        if (this.f569808f == r101.f569808f) goto L27;
        return false;
    L27:
        if (this.f569809g == r101.f569809g) goto L30;
        return false;
    L30:
        if (this.f569810h == r101.f569810h) goto L33;
        return false;
    L33:
        if (this.f569811i == r101.f569811i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f569812j, r101.f569812j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f569813k, r101.f569813k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f569814l, r101.f569814l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f569803a.hashCode() * 31;
        String r101 = this.f569804b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f569805c == false) goto L9;
        int r106 = 1231;
    L10:
        long r107 = Double.doubleToLongBits(this.f569806d);
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = Double.doubleToLongBits(this.f569807e);
        int r110 = (((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.f569808f.hashCode()) * 31;
        if (this.f569809g == false) goto L13;
        int r111 = 1231;
    L14:
        int r112 = (r110 + r111) * 31;
        if (this.f569810h == false) goto L17;
        int r113 = 1231;
    L18:
        int r114 = (r112 + r113) * 31;
        if (this.f569811i == true) goto L22;
        r105 = 1237;
    L22:
        int r115 = (r114 + r105) * 31;
        String r116 = this.f569812j;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f569813k;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f569814l;
        if (r122 == null) goto L35;
        r102 = r122.hashCode();
    L35:
        return r121 + r102;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L17:
        r113 = 1237;
        goto L18
    L13:
        r111 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MembershipQuotaRow(kind=" + this.f569803a + ", serverLabel=" + this.f569804b + ", isTeamSubscription=" + this.f569805c + ", usedPercent=" + this.f569806d + ", barPercent=" + this.f569807e + ", barTier=" + this.f569808f + ", lessThanOnePercent=" + this.f569809g + ", exhausted=" + this.f569810h + ", unlimited=" + this.f569811i + ", usedAmount=" + this.f569812j + ", totalAmount=" + this.f569813k + ", refreshAt=" + this.f569814l + ')';
    }

    public b(MembershipQuotaRowKind r100, String r101, boolean r102, double r103, double r104, MembershipQuotaBarTier r105, boolean r110, boolean r111, boolean r112, String r113, String r114, Long r115) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r105, "barTier");
        this.f569803a = r100;
        this.f569804b = r101;
        this.f569805c = r102;
        this.f569806d = r103;
        this.f569807e = r104;
        this.f569808f = r105;
        this.f569809g = r110;
        this.f569810h = r111;
        this.f569811i = r112;
        this.f569812j = r113;
        this.f569813k = r114;
        this.f569814l = r115;
    }
}

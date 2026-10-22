package uj5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f550381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f550382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f550383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f550384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f550385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f550386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f550387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f550388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f550389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f550390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f550391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f550392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f550393n;

    public b() {
        this(null, 0, false, null, null, null, null, false, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f550380a, r101.f550380a) == true) goto L12;
        return false;
    L12:
        if (this.f550381b == r101.f550381b) goto L15;
        return false;
    L15:
        if (this.f550382c == r101.f550382c) goto L18;
        return false;
    L18:
        if (this.f550383d == r101.f550383d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f550384e, r101.f550384e) == true) goto L24;
        return false;
    L24:
        if (this.f550385f == r101.f550385f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f550386g, r101.f550386g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f550387h, r101.f550387h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f550388i, r101.f550388i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f550389j, r101.f550389j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f550390k, r101.f550390k) == true) goto L42;
        return false;
    L42:
        if (this.f550391l == r101.f550391l) goto L45;
        return false;
    L45:
        if (this.f550392m == r101.f550392m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f550393n, r101.f550393n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f550380a.hashCode() * 31) + this.f550381b) * 31;
        int r101 = 1231;
        if (this.f550382c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f550383d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f550384e.hashCode()) * 31;
        if (this.f550385f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((((((((((r105 + r106) * 31) + this.f550386g.hashCode()) * 31) + this.f550387h.hashCode()) * 31) + this.f550388i.hashCode()) * 31) + this.f550389j.hashCode()) * 31) + this.f550390k.hashCode()) * 31;
        if (this.f550391l == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f550392m == true) goto L23;
        r101 = 1237;
    L23:
        return ((r109 + r101) * 31) + this.f550393n.hashCode();
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PermissionSettingParams(token=" + this.f550380a + ", objType=" + this.f550381b + ", isSpaceV2=" + this.f550382c + ", isWiki=" + this.f550383d + ", creatorTenantId=" + this.f550384e + ", isAtVc=" + this.f550385f + ", subFileType=" + this.f550386g + ", module=" + this.f550387h + ", subModule=" + this.f550388i + ", usePermissionStr=" + this.f550389j + ", publicPermissionStr=" + this.f550390k + ", isOwner=" + this.f550391l + ", hasLeader=" + this.f550392m + ", url=" + this.f550393n + ')';
    }

    public /* synthetic */ b(String r110, int r210, boolean r211, String r212, String r213, String r214, String r215, boolean r216, String r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r218 & 2) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r218 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r218 & 16) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r218 & 64) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r218 & 128) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r218 & 256) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r218 & 512) == 0) goto L33;
        String r113 = "";
    L35:
        if ((r218 & 1024) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r218 & 2048) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r218 & 4096) == 0) goto L45;
        boolean r116 = true;
    L47:
        if ((r218 & 8192) == 0) goto L49;
        String r117 = "";
    L50:
        this(r100, r101, r102, false, r103, false, r104, r111, r112, r113, r114, r115, r116, r117);
        return;
    L49:
        r117 = r217;
        goto L50
    L45:
        r116 = false;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = r214;
        goto L31
    L25:
        r111 = r213;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, int r101, boolean r102, boolean r103, String r104, boolean r105, String r106, String r107, String r110, String r111, String r112, boolean r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r104, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r106, "subFileType");
        Intrinsics.checkNotNullParameter(r107, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r110, "subModule");
        Intrinsics.checkNotNullParameter(r111, "usePermissionStr");
        Intrinsics.checkNotNullParameter(r112, "publicPermissionStr");
        Intrinsics.checkNotNullParameter(r115, "url");
        this.f550380a = r100;
        this.f550381b = r101;
        this.f550382c = r102;
        this.f550383d = r103;
        this.f550384e = r104;
        this.f550385f = r105;
        this.f550386g = r106;
        this.f550387h = r107;
        this.f550388i = r110;
        this.f550389j = r111;
        this.f550390k = r112;
        this.f550391l = r113;
        this.f550392m = r114;
        this.f550393n = r115;
    }
}

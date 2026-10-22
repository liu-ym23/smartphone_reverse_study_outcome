package jza;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f501219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f501220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f501221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f501222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f501223h;

    public a() {
        this(null, null, null, null, true, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501216a, r101.f501216a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501217b, r101.f501217b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f501218c, r101.f501218c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501219d, r101.f501219d) == true) goto L21;
        return false;
    L21:
        if (this.f501220e == r101.f501220e) goto L24;
        return false;
    L24:
        if (this.f501221f == r101.f501221f) goto L27;
        return false;
    L27:
        if (this.f501222g == r101.f501222g) goto L30;
        return false;
    L30:
        if (this.f501223h == r101.f501223h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f501216a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f501217b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f501218c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f501219d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        int r112 = 1231;
        if (this.f501220e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r111 + r113) * 31;
        if (this.f501221f == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f501222g == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f501223h == true) goto L35;
        r112 = 1237;
    L35:
        return r118 + r112;
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
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
        return "FlowFilePreviewSecurityContext(chatId=" + this.f501216a + ", senderId=" + this.f501217b + ", senderTenantId=" + this.f501218c + ", receiveAuthorizationStateValue=" + this.f501219d + ", hasReceivePermission=" + this.f501220e + ", isResourceCleaned=" + this.f501221f + ", isCSAMDeleted=" + this.f501222g + ", isKnownRiskFile=" + this.f501223h + ')';
    }

    public a(String r100, String r101, String r102, Integer r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.f501216a = r100;
        this.f501217b = r101;
        this.f501218c = r102;
        this.f501219d = r103;
        this.f501220e = r104;
        this.f501221f = r105;
        this.f501222g = r106;
        this.f501223h = r107;
    }
}

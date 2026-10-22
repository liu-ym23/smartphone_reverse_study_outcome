package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f554350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f554351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f554354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f554356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f554357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f554358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f554359j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f554350a == r101.f554350a) goto L12;
        return false;
    L12:
        if (this.f554351b == r101.f554351b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554352c, r101.f554352c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554353d, r101.f554353d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554354e, r101.f554354e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554355f, r101.f554355f) == true) goto L27;
        return false;
    L27:
        if (this.f554356g == r101.f554356g) goto L30;
        return false;
    L30:
        if (this.f554357h == r101.f554357h) goto L33;
        return false;
    L33:
        if (this.f554358i == r101.f554358i) goto L36;
        return false;
    L36:
        if (this.f554359j == r101.f554359j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f554350a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f554351b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        String r105 = this.f554352c;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f554353d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.f554354e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f554355f;
        if (r115 == null) goto L22;
        r106 = r115.hashCode();
    L22:
        int r116 = (r114 + r106) * 31;
        if (this.f554356g == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f554357h == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f554358i == true) goto L34;
        r102 = 1237;
    L34:
        int r121 = (r120 + r102) * 31;
        long r122 = this.f554359j;
        return r121 + ((int) (r122 ^ (r122 >>> 32)));
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotConfigCacheEntry(botId=" + this.f554350a + ", finishedConfig=" + this.f554351b + ", authUrl=" + this.f554352c + ", deviceCode=" + this.f554353d + ", deviceCodeExpireTime=" + this.f554354e + ", helpDocUrl=" + this.f554355f + ", isStoreApp=" + this.f554356g + ", isAppManager=" + this.f554357h + ", hasAppVisibility=" + this.f554358i + ", fetchedAt=" + this.f554359j + ')';
    }

    public b(long r100, boolean r101, String r102, String r103, Long r104, String r105, boolean r106, boolean r107, boolean r110, long r111) {
        this.f554350a = r100;
        this.f554351b = r101;
        this.f554352c = r102;
        this.f554353d = r103;
        this.f554354e = r104;
        this.f554355f = r105;
        this.f554356g = r106;
        this.f554357h = r107;
        this.f554358i = r110;
        this.f554359j = r111;
    }
}

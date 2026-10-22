package ve9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f554448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554451h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f554444a, r101.f554444a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554445b, r101.f554445b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554446c, r101.f554446c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554447d, r101.f554447d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554448e, r101.f554448e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554449f, r101.f554449f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f554450g, r101.f554450g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554451h, r101.f554451h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f554444a.hashCode() * 31) + this.f554445b.hashCode()) * 31) + this.f554446c.hashCode()) * 31) + this.f554447d.hashCode()) * 31;
        String r101 = this.f554448e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + this.f554449f.hashCode()) * 31) + this.f554450g.hashCode()) * 31) + this.f554451h.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommonConfig(userId=" + this.f554444a + ", deviceId=" + this.f554445b + ", appVersion=" + this.f554446c + ", updateVersionCode=" + this.f554447d + ", packageType=" + this.f554448e + ", conversationId=" + this.f554449f + ", botId=" + this.f554450g + ", token=" + this.f554451h + ')';
    }

    public e(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        Intrinsics.checkNotNullParameter(r103, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "botId");
        Intrinsics.checkNotNullParameter(r106, "token");
        this.f554444a = r100;
        this.f554445b = r101;
        this.f554446c = r102;
        this.f554447d = r103;
        this.f554448e = null;
        this.f554449f = r104;
        this.f554450g = r105;
        this.f554451h = r106;
    }
}

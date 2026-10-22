package eu7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f474086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f474089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f474091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474092h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474085a, r101.f474085a) == true) goto L12;
        return false;
    L12:
        if (this.f474086b == r101.f474086b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474087c, r101.f474087c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474088d, r101.f474088d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474089e, r101.f474089e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474090f, r101.f474090f) == true) goto L27;
        return false;
    L27:
        if (this.f474091g == r101.f474091g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474092h, r101.f474092h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474085a.hashCode() * 31;
        long r101 = this.f474086b;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f474087c.hashCode()) * 31) + this.f474088d.hashCode()) * 31;
        Boolean r103 = this.f474089e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((r102 + r104) * 31) + this.f474090f.hashCode()) * 31;
        long r106 = this.f474091g;
        return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f474092h.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "PerfTracer(info=" + this.f474085a + ", duration=" + this.f474086b + ", threadName=" + this.f474087c + ", appState=" + this.f474088d + ", isCharging=" + this.f474089e + ", screenState=" + this.f474090f + ", appStartTime=" + this.f474091g + ", extra=" + this.f474092h + ')';
    }

    public a(String r100, long r101, String r102, String r103, Boolean r104, String r105, long r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r102, "threadName");
        Intrinsics.checkNotNullParameter(r103, "appState");
        Intrinsics.checkNotNullParameter(r105, "screenState");
        Intrinsics.checkNotNullParameter(r110, "extra");
        this.f474085a = r100;
        this.f474086b = r101;
        this.f474087c = r102;
        this.f474088d = r103;
        this.f474089e = r104;
        this.f474090f = r105;
        this.f474091g = r106;
        this.f474092h = r110;
    }
}

package z2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f569824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f569826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f569827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f569828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f569829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f569830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f569831j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f569822a, r101.f569822a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569823b, r101.f569823b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f569824c, r101.f569824c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569825d, r101.f569825d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f569826e, r101.f569826e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f569827f, r101.f569827f) == true) goto L27;
        return false;
    L27:
        if (this.f569828g == r101.f569828g) goto L30;
        return false;
    L30:
        if (this.f569829h == r101.f569829h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f569830i, r101.f569830i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f569831j, r101.f569831j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f569822a.hashCode() * 31) + this.f569823b.hashCode()) * 31) + this.f569824c.hashCode()) * 31) + this.f569825d.hashCode()) * 31) + this.f569826e.hashCode()) * 31) + this.f569827f.hashCode()) * 31) + this.f569828g) * 31;
        long r101 = this.f569829h;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f569830i;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f569831j;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MuseumInAppNotification(title=" + this.f569822a + ", content=" + this.f569823b + ", icon=" + this.f569824c + ", museum=" + this.f569825d + ", stage=" + this.f569826e + ", buttonText=" + this.f569827f + ", priority=" + this.f569828g + ", autoDismissSeconds=" + this.f569829h + ", conversationId=" + this.f569830i + ", callId=" + this.f569831j + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, int r106, long r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "icon");
        Intrinsics.checkNotNullParameter(r103, "museum");
        Intrinsics.checkNotNullParameter(r104, "stage");
        Intrinsics.checkNotNullParameter(r105, "buttonText");
        this.f569822a = r100;
        this.f569823b = r101;
        this.f569824c = r102;
        this.f569825d = r103;
        this.f569826e = r104;
        this.f569827f = r105;
        this.f569828g = r106;
        this.f569829h = r107;
        this.f569830i = r110;
        this.f569831j = r111;
    }
}

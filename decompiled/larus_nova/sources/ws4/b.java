package ws4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f561038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f561039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f561040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f561041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f561042f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f561037a, r101.f561037a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f561038b, r101.f561038b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f561039c, r101.f561039c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f561040d, r101.f561040d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f561041e, r101.f561041e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f561042f, r101.f561042f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f561037a.hashCode() * 31) + this.f561038b.hashCode()) * 31) + this.f561039c.hashCode()) * 31) + this.f561040d.hashCode()) * 31;
        String r101 = this.f561041e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f561042f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BitableHomePageV4ConsumerParams(containerEnv=" + this.f561037a + ", tabLoadFrom=" + this.f561038b + ", scene=" + this.f561039c + ", reason=" + this.f561040d + ", result=" + this.f561041e + ", detail=" + this.f561042f + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "containerEnv");
        Intrinsics.checkNotNullParameter(r101, "tabLoadFrom");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "reason");
        this.f561037a = r100;
        this.f561038b = r101;
        this.f561039c = r102;
        this.f561040d = r103;
        this.f561041e = r104;
        this.f561042f = r105;
    }

    public /* synthetic */ b(String r100, String r101, String r110, String r111, String r112, int r113) {
        if ((r113 & 16) == 0) goto L5;
        r112 = null;
    L5:
        this(r100, r101, r110, r111, r112, null);
    }
}

package la;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f508151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f508152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f508154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f508155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f508156f;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f508151a, r101.f508151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508152b, r101.f508152b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508153c, r101.f508153c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508154d, r101.f508154d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508155e, r101.f508155e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508156f, r101.f508156f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f508151a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f508152b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f508153c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f508154d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f508155e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f508156f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ReportData(containerId=" + this.f508151a + ", currentUrl=" + this.f508152b + ", reportText=" + this.f508153c + ", traceIdForContainer=" + this.f508154d + ", traceIdForView=" + this.f508155e + ", secLinkScene=" + this.f508156f + ')';
    }

    public c(int r100) {
        this.f508151a = null;
        this.f508152b = null;
        this.f508153c = null;
        this.f508154d = null;
        this.f508155e = null;
        this.f508156f = null;
    }
}

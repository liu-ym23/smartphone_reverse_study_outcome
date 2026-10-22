package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f478687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f478690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f478691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f478692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f478693g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f478687a == r101.f478687a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478688b, r101.f478688b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478689c, r101.f478689c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f478690d, r101.f478690d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f478691e, r101.f478691e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f478692f, r101.f478692f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f478693g, r101.f478693g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f478687a * 31;
        String r101 = this.f478688b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f478689c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f478690d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f478691e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f478692f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f478693g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RequestCreationGroupData(pageSize=" + this.f478687a + ", visitId=" + this.f478688b + ", cursor=" + this.f478689c + ", privateStatus=" + this.f478690d + ", downgradeSource=" + this.f478691e + ", visitLarkId=" + this.f478692f + ", from=" + this.f478693g + ')';
    }

    public x(int r100, String r101, String r102, Integer r103, String r104, String r105, Integer r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r110 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r110 & 64) == 0) goto L17;
        r106 = 0;
    L17:
        this.f478687a = r100;
        this.f478688b = r101;
        this.f478689c = r102;
        this.f478690d = r103;
        this.f478691e = r104;
        this.f478692f = r105;
        this.f478693g = r106;
    }
}

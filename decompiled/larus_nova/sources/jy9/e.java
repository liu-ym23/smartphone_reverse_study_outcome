package jy9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic8.d f500981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic8.d f500982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic8.d f500983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic8.d f500984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ic8.d f500985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic8.d f500986f;

    public e() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f500981a, r101.f500981a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500982b, r101.f500982b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500983c, r101.f500983c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500984d, r101.f500984d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500985e, r101.f500985e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f500986f, r101.f500986f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f500981a.hashCode() * 31) + this.f500982b.hashCode()) * 31) + this.f500983c.hashCode()) * 31) + this.f500984d.hashCode()) * 31) + this.f500985e.hashCode()) * 31) + this.f500986f.hashCode();
    }

    public final String toString() {
        return "CreationAiEditParams(aiVideoParams=" + this.f500981a + ", aiImageParams=" + this.f500982b + ", aiImageExpandParams=" + this.f500983c + ", aiImageErasePrams=" + this.f500984d + ", aiImageSharepnessParams=" + this.f500985e + ", aiVideoExtendParams=" + this.f500986f + ')';
    }

    public /* synthetic */ e(ic8.d r110, ic8.d r111, ic8.d r112, ic8.d r210, ic8.d r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        ic8.d r113 = new ic8.d(false, null, null, false, null, null, 63);
    L7:
        if ((r212 & 2) == 0) goto L9;
        ic8.d r114 = new ic8.d(false, null, null, false, null, null, 63);
    L11:
        if ((r212 & 4) == 0) goto L13;
        ic8.d r115 = new ic8.d(false, null, null, false, null, null, 63);
    L15:
        if ((r212 & 8) == 0) goto L17;
        ic8.d r116 = new ic8.d(false, null, null, false, null, null, 63);
    L19:
        if ((r212 & 16) == 0) goto L21;
        ic8.d r117 = new ic8.d(false, null, null, false, null, null, 63);
    L23:
        if ((r212 & 32) == 0) goto L25;
        ic8.d r100 = new ic8.d(false, null, null, false, null, null, 63);
    L26:
        this(r113, r114, r115, r116, r117, r100);
        return;
    L25:
        r100 = null;
        goto L26
    L21:
        r117 = r211;
        goto L23
    L17:
        r116 = r210;
        goto L19
    L13:
        r115 = r112;
        goto L15
    L9:
        r114 = r111;
        goto L11
    L5:
        r113 = r110;
        goto L7
    }

    public e(ic8.d r100, ic8.d r101, ic8.d r102, ic8.d r103, ic8.d r104, ic8.d r105) {
        Intrinsics.checkNotNullParameter(r100, "aiVideoParams");
        Intrinsics.checkNotNullParameter(r101, "aiImageParams");
        Intrinsics.checkNotNullParameter(r102, "aiImageExpandParams");
        Intrinsics.checkNotNullParameter(r103, "aiImageErasePrams");
        Intrinsics.checkNotNullParameter(r104, "aiImageSharepnessParams");
        Intrinsics.checkNotNullParameter(r105, "aiVideoExtendParams");
        this.f500981a = r100;
        this.f500982b = r101;
        this.f500983c = r102;
        this.f500984d = r103;
        this.f500985e = r104;
        this.f500986f = r105;
    }
}

package eba;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f471959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f471960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jba.b f471962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f471963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f471964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jba.f f471965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jba.a f471966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f471967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final jba.c f471969k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f471959a == r101.f471959a) goto L12;
        return false;
    L12:
        if (this.f471960b == r101.f471960b) goto L15;
        return false;
    L15:
        if (this.f471961c == r101.f471961c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471962d, r101.f471962d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f471963e, r101.f471963e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f471964f, r101.f471964f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f471965g, r101.f471965g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f471966h, r101.f471966h) == true) goto L33;
        return false;
    L33:
        if (this.f471967i == r101.f471967i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f471968j, r101.f471968j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f471969k, r101.f471969k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f471959a * 31) + this.f471960b) * 31) + this.f471961c) * 31) + this.f471962d.hashCode()) * 31) + this.f471963e.hashCode()) * 31;
        Integer r101 = this.f471964f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        jba.f r105 = this.f471965g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((((((r104 + r102) * 31) + this.f471966h.hashCode()) * 31) + this.f471967i) * 31) + this.f471968j.hashCode()) * 31) + this.f471969k.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricListeningChildWindowGeometryTrace(displayWidth=" + this.f471959a + ", displayHeight=" + this.f471960b + ", orientation=" + this.f471961c + ", cutoutInsets=" + this.f471962d + ", cutoutSource=" + this.f471963e + ", navigationMode=" + this.f471964f + ", navigationBarInsetsSnapshot=" + this.f471965g + ", consumedNavigationBarInsets=" + this.f471966h + ", edgeMarginPx=" + this.f471967i + ", windowInsetsSource=" + this.f471968j + ", systemCornerRadii=" + this.f471969k + ')';
    }

    public final String a() {
        return "display=" + this.f471959a + Permission.EXECUTE + this.f471960b + " orientation=" + this.f471961c + " cutout=" + this.f471962d + " cutoutSource=" + this.f471963e + " navMode=" + this.f471964f + " navSnapshot=" + this.f471965g + " consumedNav=" + this.f471966h + " edgeMarginPx=" + this.f471967i + " windowInsetsSource=" + this.f471968j + " systemRadii=" + this.f471969k;
    }

    public m(int r100, int r101, int r102, jba.b r103, String r104, Integer r105, jba.f r106, jba.a r107, int r110, String r111, jba.c r112) {
        Intrinsics.checkNotNullParameter(r103, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r104, "cutoutSource");
        Intrinsics.checkNotNullParameter(r107, "consumedNavigationBarInsets");
        Intrinsics.checkNotNullParameter(r111, "windowInsetsSource");
        Intrinsics.checkNotNullParameter(r112, "systemCornerRadii");
        this.f471959a = r100;
        this.f471960b = r101;
        this.f471961c = r102;
        this.f471962d = r103;
        this.f471963e = r104;
        this.f471964f = r105;
        this.f471965g = r106;
        this.f471966h = r107;
        this.f471967i = r110;
        this.f471968j = r111;
        this.f471969k = r112;
    }
}

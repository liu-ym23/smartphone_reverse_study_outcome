package di8;

import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f468837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f468838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PcDevice f468839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f468840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f468841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f468842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f468843g;

    public p0() {
        this(null, false, null, null, null, null, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f468837a, r101.f468837a) == true) goto L12;
        return false;
    L12:
        if (this.f468838b == r101.f468838b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468839c, r101.f468839c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468840d, r101.f468840d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f468841e, r101.f468841e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468842f, r101.f468842f) == true) goto L27;
        return false;
    L27:
        if (this.f468843g == r101.f468843g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        f0 r100 = this.f468837a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f468838b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        PcDevice r107 = this.f468839c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f468840d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f468841e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f468842f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.f468843g == true) goto L31;
        r104 = 1237;
    L31:
        return r117 + r104;
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
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeTaskComputerPayload(originSourcePayload=" + this.f468837a + ", isCloudComputer=" + this.f468838b + ", pcDevice=" + this.f468839c + ", foldMenuSelectedName=" + this.f468840d + ", selectedName=" + this.f468841e + ", selectedIconUrl=" + this.f468842f + ", isConnectGuide=" + this.f468843g + ')';
    }

    @Override // di8.a0
    public final String a() {
        return this.f468841e;
    }

    @Override // di8.a0
    public final String b() {
        return this.f468842f;
    }

    public p0(f0 r100, boolean r101, PcDevice r102, String r103, String r104, String r105, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L23;
        r110 = false;
    L23:
        this.f468837a = r100;
        this.f468838b = r101;
        this.f468839c = r102;
        this.f468840d = r103;
        this.f468841e = r104;
        this.f468842f = r105;
        this.f468843g = r110;
    }
}

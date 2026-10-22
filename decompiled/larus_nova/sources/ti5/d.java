package ti5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f546114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f546116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f546117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f546118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f546119g;

    public d() {
        this(false, false, null, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f546113a == r101.f546113a) goto L12;
        return false;
    L12:
        if (this.f546114b == r101.f546114b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546115c, r101.f546115c) == true) goto L18;
        return false;
    L18:
        if (this.f546116d == r101.f546116d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f546117e, r101.f546117e) == true) goto L24;
        return false;
    L24:
        if (this.f546118f == r101.f546118f) goto L27;
        return false;
    L27:
        if (this.f546119g == r101.f546119g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f546113a * 31;
        int r101 = 1231;
        if (this.f546114b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f546115c.hashCode()) * 31;
        if (this.f546116d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f546117e.hashCode()) * 31;
        if (this.f546118f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f546119g == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TransferApplyData(permissionData=" + this.f546113a + ", isSelected=" + this.f546114b + ", description=" + this.f546115c + ", showSelectedPermission=" + this.f546116d + ", title=" + this.f546117e + ", showDivider=" + this.f546118f + ", savePermission=" + this.f546119g + ')';
    }

    public d(boolean r100, boolean r101, String r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        String r105 = "";
    L10:
        if ((r104 & 8) == 0) goto L13;
        r101 = false;
    L13:
        if ((r104 & 16) == 0) goto L16;
        r102 = "";
    L16:
        if ((r104 & 32) == 0) goto L19;
        r103 = false;
    L19:
        if ((r104 & 64) == 0) goto L21;
        boolean r106 = true;
    L22:
        Intrinsics.checkNotNullParameter(r105, "description");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f546113a = 0;
        this.f546114b = r100;
        this.f546115c = r105;
        this.f546116d = r101;
        this.f546117e = r102;
        this.f546118f = r103;
        this.f546119g = r106;
        return;
    L21:
        r106 = false;
        goto L22
    L8:
        r105 = null;
        goto L10
    }
}

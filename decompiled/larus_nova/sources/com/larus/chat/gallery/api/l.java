package com.larus.chat.gallery.api;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f324163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f324164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f324165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f324166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f324167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324168g;

    public l() {
        this(false, false, false, false, false, false, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f324162a == r101.f324162a) goto L12;
        return false;
    L12:
        if (this.f324163b == r101.f324163b) goto L15;
        return false;
    L15:
        if (this.f324164c == r101.f324164c) goto L18;
        return false;
    L18:
        if (this.f324165d == r101.f324165d) goto L21;
        return false;
    L21:
        if (this.f324166e == r101.f324166e) goto L24;
        return false;
    L24:
        if (this.f324167f == r101.f324167f) goto L27;
        return false;
    L27:
        if (this.f324168g == r101.f324168g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f324162a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f324163b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f324164c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f324165d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f324166e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f324167f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f324168g == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewCapability(canUseInput=" + this.f324162a + ", canSelect=" + this.f324163b + ", canEdit=" + this.f324164c + ", canRemove=" + this.f324165d + ", canApplyOwnerMutation=" + this.f324166e + ", canSend=" + this.f324167f + ", canOpenAlbum=" + this.f324168g + ')';
    }

    public l(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.f324162a = r100;
        this.f324163b = r101;
        this.f324164c = r102;
        this.f324165d = r103;
        this.f324166e = r104;
        this.f324167f = r105;
        this.f324168g = r106;
    }

    public /* synthetic */ l(boolean r100, boolean r101, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r115 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r115 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r115 & 64) == 0) goto L29;
        boolean r116 = false;
    L30:
        this(r102, r103, r104, r105, r106, r107, r116);
        return;
    L29:
        r116 = r114;
        goto L30
    L25:
        r107 = r113;
        goto L27
    L21:
        r106 = r112;
        goto L23
    L17:
        r105 = r111;
        goto L19
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}

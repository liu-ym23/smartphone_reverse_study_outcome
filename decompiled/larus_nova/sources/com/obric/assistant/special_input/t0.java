package com.obric.assistant.special_input;

/* JADX INFO: loaded from: classes33.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f392775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f392776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f392777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f392778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f392779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f392780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f392781g;

    public static final class a {
    }

    static {
    }

    public t0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.f392775a == r101.f392775a) goto L12;
        return false;
    L12:
        if (this.f392776b == r101.f392776b) goto L15;
        return false;
    L15:
        if (this.f392777c == r101.f392777c) goto L18;
        return false;
    L18:
        if (this.f392778d == r101.f392778d) goto L21;
        return false;
    L21:
        if (this.f392779e == r101.f392779e) goto L24;
        return false;
    L24:
        if (this.f392780f == r101.f392780f) goto L27;
        return false;
    L27:
        if (this.f392781g == r101.f392781g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f392775a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f392776b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f392777c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f392778d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.f392779e) * 31;
        if (this.f392780f == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f392781g == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
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
        return "SkillExtensionSettingState(enabled=" + this.f392775a + ", hasLocalCache=" + this.f392776b + ", hasLoadedRemote=" + this.f392777c + ", lastSyncSuccess=" + this.f392778d + ", omniSkillAvailableState=" + this.f392779e + ", hasLoadedOmniSkillAvailableRemote=" + this.f392780f + ", omniSkillAvailableLastSyncSuccess=" + this.f392781g + ')';
    }

    public /* synthetic */ t0(int r100) {
        this(false, false, false, false, -1, false, false);
    }

    public t0(boolean r100, boolean r101, boolean r102, boolean r103, int r104, boolean r105, boolean r106) {
        this.f392775a = r100;
        this.f392776b = r101;
        this.f392777c = r102;
        this.f392778d = r103;
        this.f392779e = r104;
        this.f392780f = r105;
        this.f392781g = r106;
    }

    public static t0 a(t0 r100, boolean r101, boolean r110, boolean r111, boolean r112, int r113, boolean r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        boolean r102 = r100.f392775a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r103 = r100.f392776b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r104 = r100.f392777c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        boolean r105 = r100.f392778d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        int r106 = r100.f392779e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r107 = r100.f392780f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r108 = r100.f392781g;
    L30:
        r100.getClass();
        return new t0(r102, r103, r104, r105, r106, r107, r108);
    L29:
        r108 = r115;
        goto L30
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}

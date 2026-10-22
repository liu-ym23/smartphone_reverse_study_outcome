package com.larus.avlink.business.timeout;

/* JADX INFO: loaded from: classes23.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f291724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f291725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f291726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f291727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f291728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f291729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f291730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f291731h;

    public f() {
        this(true, false, false, false, false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f291724a == r101.f291724a) goto L12;
        return false;
    L12:
        if (this.f291725b == r101.f291725b) goto L15;
        return false;
    L15:
        if (this.f291726c == r101.f291726c) goto L18;
        return false;
    L18:
        if (this.f291727d == r101.f291727d) goto L21;
        return false;
    L21:
        if (this.f291728e == r101.f291728e) goto L24;
        return false;
    L24:
        if (this.f291729f == r101.f291729f) goto L27;
        return false;
    L27:
        if (this.f291730g == r101.f291730g) goto L30;
        return false;
    L30:
        if (this.f291731h == r101.f291731h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f291724a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f291725b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f291726c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f291727d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f291728e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f291729f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f291730g == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f291731h == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
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
        return "DoraAvlinkTimeoutEnvironment(supportHardwareAbilityShift=" + this.f291724a + ", isOnboarding=" + this.f291725b + ", isSimulInterpretMode=" + this.f291726c + ", isLiveAiMode=" + this.f291727d + ", isEnvironmentObserveMode=" + this.f291728e + ", environmentObserveInConversation=" + this.f291729f + ", isNotMainBot=" + this.f291730g + ", isRadioTalk=" + this.f291731h + ')';
    }

    public f(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.f291724a = r100;
        this.f291725b = r101;
        this.f291726c = r102;
        this.f291727d = r103;
        this.f291728e = r104;
        this.f291729f = r105;
        this.f291730g = r106;
        this.f291731h = r107;
    }
}

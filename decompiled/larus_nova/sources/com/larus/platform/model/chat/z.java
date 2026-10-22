package com.larus.platform.model.chat;

/* JADX INFO: loaded from: classes31.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f365608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f365609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f365610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f365611f;

    public z() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f365606a == r101.f365606a) goto L12;
        return false;
    L12:
        if (this.f365607b == r101.f365607b) goto L15;
        return false;
    L15:
        if (this.f365608c == r101.f365608c) goto L18;
        return false;
    L18:
        if (this.f365609d == r101.f365609d) goto L21;
        return false;
    L21:
        if (this.f365610e == r101.f365610e) goto L24;
        return false;
    L24:
        if (this.f365611f == r101.f365611f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365606a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f365607b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f365608c) * 31;
        if (this.f365609d == true) goto L15;
        r100 = 1237;
    L15:
        return ((((r104 + r100) * 31) + this.f365610e) * 31) + this.f365611f;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LatestPhotoShortcutConfig(mainBotEnabled=" + this.f365606a + ", ugcBotEnabled=" + this.f365607b + ", photoTargetSource=" + this.f365608c + ", skipAttachment=" + this.f365609d + ", showDurationMs=" + this.f365610e + ", asLatestDurationMs=" + this.f365611f + ')';
    }

    public /* synthetic */ z(int r100) {
        this(false, false, 0, false, 3000, 20000);
    }

    public z(boolean r100, boolean r101, int r102, boolean r103, int r104, int r105) {
        this.f365606a = r100;
        this.f365607b = r101;
        this.f365608c = r102;
        this.f365609d = r103;
        this.f365610e = r104;
        this.f365611f = r105;
    }
}

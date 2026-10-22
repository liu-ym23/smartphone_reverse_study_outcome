package com.bytedance.ee.bear.more.protocol3.panel;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f234941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f234945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f234947g;

    public c0() {
        this(false, false, false, false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f234941a == r101.f234941a) goto L12;
        return false;
    L12:
        if (this.f234942b == r101.f234942b) goto L15;
        return false;
    L15:
        if (this.f234943c == r101.f234943c) goto L18;
        return false;
    L18:
        if (this.f234944d == r101.f234944d) goto L21;
        return false;
    L21:
        if (this.f234945e == r101.f234945e) goto L24;
        return false;
    L24:
        if (this.f234946f == r101.f234946f) goto L27;
        return false;
    L27:
        if (this.f234947g == r101.f234947g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f234941a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f234942b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f234943c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f234944d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f234945e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f234946f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f234947g == true) goto L31;
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
        return "MorePanelPermission(isOwner=" + this.f234941a + ", canEdit=" + this.f234942b + ", canCopy=" + this.f234943c + ", canCreateCopy=" + this.f234944d + ", canExport=" + this.f234945e + ", canOperateEntity=" + this.f234946f + ", canManagePermissionMeta=" + this.f234947g + ')';
    }

    public c0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.f234941a = r100;
        this.f234942b = r101;
        this.f234943c = r102;
        this.f234944d = r103;
        this.f234945e = r104;
        this.f234946f = r105;
        this.f234947g = r106;
    }
}

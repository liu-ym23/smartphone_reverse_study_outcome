package com.ss.android.lark.profile_office.userprofile;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f438912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f438913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f438914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f438915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f438916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f438917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f438918g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f438912a == r101.f438912a) goto L12;
        return false;
    L12:
        if (this.f438913b == r101.f438913b) goto L15;
        return false;
    L15:
        if (this.f438914c == r101.f438914c) goto L18;
        return false;
    L18:
        if (this.f438915d == r101.f438915d) goto L21;
        return false;
    L21:
        if (this.f438916e == r101.f438916e) goto L24;
        return false;
    L24:
        if (this.f438917f == r101.f438917f) goto L27;
        return false;
    L27:
        if (this.f438918g == r101.f438918g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f438912a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f438913b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f438914c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f438915d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f438916e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f438917f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f438918g == true) goto L31;
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
        return "OfficeProfileDialogState(showEditAliasDialog=" + this.f438912a + ", isSavingAlias=" + this.f438913b + ", showApplyFriendDialog=" + this.f438914c + ", isSendingFriendRequest=" + this.f438915d + ", showReportPopup=" + this.f438916e + ", showDeleteFriendDialog=" + this.f438917f + ", showBlockedDialog=" + this.f438918g + ')';
    }

    public /* synthetic */ d(int r100) {
        this(false, false, false, false, false, false, false);
    }

    public d(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.f438912a = r100;
        this.f438913b = r101;
        this.f438914c = r102;
        this.f438915d = r103;
        this.f438916e = r104;
        this.f438917f = r105;
        this.f438918g = r106;
    }

    public static d a(d r100, boolean r101, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        boolean r102 = r100.f438912a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r103 = r100.f438913b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r104 = r100.f438914c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        boolean r105 = r100.f438915d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r106 = r100.f438916e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r107 = r100.f438917f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r108 = r100.f438918g;
    L30:
        r100.getClass();
        return new d(r102, r103, r104, r105, r106, r107, r108);
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

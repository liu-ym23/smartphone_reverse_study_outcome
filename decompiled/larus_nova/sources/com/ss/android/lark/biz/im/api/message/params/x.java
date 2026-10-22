package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class x implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f410393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f410394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f410395f;

    public x() {
        int r100 = 0;
        this(r100, r100, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f410390a == r101.f410390a) goto L12;
        return false;
    L12:
        if (this.f410391b == r101.f410391b) goto L15;
        return false;
    L15:
        if (this.f410392c == r101.f410392c) goto L18;
        return false;
    L18:
        if (this.f410393d == r101.f410393d) goto L21;
        return false;
    L21:
        if (this.f410394e == r101.f410394e) goto L24;
        return false;
    L24:
        if (this.f410395f == r101.f410395f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f410390a * 31) + this.f410391b) * 31;
        if (this.f410392c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + this.f410393d) * 31) + this.f410394e) * 31) + this.f410395f;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SystemContentBlockParam(contentTextSize=" + this.f410390a + ", textColor=" + this.f410391b + ", enableAddFriend=" + this.f410392c + ", addFriendTextColor=" + this.f410393d + ", addFriendTextResId=" + this.f410394e + ", blockPaddingVDp=" + this.f410395f + ')';
    }

    public /* synthetic */ x(int r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r101 = -1;
    L10:
        this(r100, r101, false, 0, 0, 0);
        return;
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }

    public x(int r100, int r101, boolean r102, int r103, int r104, int r105) {
        this.f410390a = r100;
        this.f410391b = r101;
        this.f410392c = r102;
        this.f410393d = r103;
        this.f410394e = r104;
        this.f410395f = r105;
    }
}

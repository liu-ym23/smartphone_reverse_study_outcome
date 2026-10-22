package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f233300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f233301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f233302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f233304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f233305f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f233300a == r101.f233300a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f233301b, r101.f233301b) == true) goto L15;
        return false;
    L15:
        if (this.f233302c == r101.f233302c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f233303d, r101.f233303d) == true) goto L21;
        return false;
    L21:
        if (this.f233304e == r101.f233304e) goto L24;
        return false;
    L24:
        if (this.f233305f == r101.f233305f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f233300a * 31) + this.f233301b.hashCode()) * 31) + this.f233302c) * 31;
        String r101 = this.f233303d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f233304e) * 31;
        if (this.f233305f == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InviteParam(permType=" + this.f233300a + ", url=" + this.f233301b + ", type=" + this.f233302c + ", token=" + this.f233303d + ", newPermission=" + this.f233304e + ", notifyLark=" + this.f233305f + ')';
    }

    public final int getType() {
        return this.f233302c;
    }

    public g(int r100, String r101, int r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f233300a = r100;
        this.f233301b = r101;
        this.f233302c = r102;
        this.f233303d = r103;
        this.f233304e = 1;
        this.f233305f = r104;
    }
}

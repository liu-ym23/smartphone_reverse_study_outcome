package com.ss.android.lark.todo.impl.features.detail.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f442963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f442964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f442965d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f442962a, r101.f442962a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442963b, r101.f442963b) == true) goto L15;
        return false;
    L15:
        if (this.f442964c == r101.f442964c) goto L18;
        return false;
    L18:
        if (this.f442965d == r101.f442965d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f442962a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f442963b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f442964c == false) goto L13;
        int r106 = 1231;
    L15:
        return ((r105 + r106) * 31) + this.f442965d;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentAtUserInfo(userId=" + this.f442962a + ", userName=" + this.f442963b + ", isOutChat=" + this.f442964c + ", position=" + this.f442965d + ')';
    }

    public n(String r100, String r101, boolean r102) {
        this.f442962a = r100;
        this.f442963b = r101;
        this.f442964c = r102;
        this.f442965d = 0;
    }
}

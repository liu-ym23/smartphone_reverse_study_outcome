package com.bytedance.awemeopen.bizmodels.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t14.a f198232b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f198231a, r101.f198231a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f198232b, r101.f198232b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f198231a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        t14.a r104 = this.f198232b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserInfo(nickName=" + this.f198231a + ", avatarThumb=" + this.f198232b + ')';
    }

    public i(String r100, t14.a r101) {
        this.f198231a = r100;
        this.f198232b = r101;
    }
}

package com.larus.bmhome.auth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f295797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295798c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f295796a, r101.f295796a) == true) goto L12;
        return false;
    L12:
        if (this.f295797b == r101.f295797b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295798c, r101.f295798c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f295796a.hashCode() * 31;
        if (this.f295797b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f295798c.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ConversationCacheOwner(userId=" + this.f295796a + ", isLogin=" + this.f295797b + ", botId=" + this.f295798c + ')';
    }

    public g0(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r102, "botId");
        this.f295796a = r100;
        this.f295797b = r101;
        this.f295798c = r102;
    }
}

package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDAuthorizeAccountIssueType f325936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f325937b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f325936a == r101.f325936a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325937b, r101.f325937b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325936a.hashCode() * 31;
        a r101 = this.f325937b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BDAuthorizeAccountIssue(type=" + this.f325936a + ", account=" + this.f325937b + ')';
    }

    public final BDAuthorizeAccountIssueType getType() {
        return this.f325936a;
    }

    public b(BDAuthorizeAccountIssueType r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f325936a = r100;
        this.f325937b = r101;
    }
}

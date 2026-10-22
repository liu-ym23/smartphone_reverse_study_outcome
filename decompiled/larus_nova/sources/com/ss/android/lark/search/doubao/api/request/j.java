package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OuterGroupOption f439972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f439973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f439974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f439975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f439976e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f439972a == r101.f439972a) goto L12;
        return false;
    L12:
        if (this.f439973b == r101.f439973b) goto L15;
        return false;
    L15:
        if (this.f439974c == r101.f439974c) goto L18;
        return false;
    L18:
        if (this.f439975d == r101.f439975d) goto L21;
        return false;
    L21:
        if (this.f439976e == r101.f439976e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f439972a.hashCode() * 31;
        int r101 = 1231;
        if (this.f439973b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f439974c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f439975d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f439976e == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "GroupChatDslModel(outerGroup=" + this.f439972a + ", onlyManageGroup=" + this.f439973b + ", includeSecretGroup=" + this.f439974c + ", includeShieldGroup=" + this.f439975d + ", excludeUnJoinGroup=" + this.f439976e + ')';
    }

    public j(OuterGroupOption r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "outerGroup");
        this.f439972a = r100;
        this.f439973b = r101;
        this.f439974c = r102;
        this.f439975d = r103;
        this.f439976e = r104;
    }
}

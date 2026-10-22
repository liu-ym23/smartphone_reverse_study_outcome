package com.obric.assistant.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f390248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f390250c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f390248a == r101.f390248a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390249b, r101.f390249b) == true) goto L15;
        return false;
    L15:
        if (this.f390250c == r101.f390250c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f390248a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f390249b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f390250c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AssistantAccountSnapshot(isLogin=" + this.f390248a + ", secUserId=" + this.f390249b + ", isEnterprise=" + this.f390250c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(false, null, false);
    }

    public a(boolean r100, String r101, boolean r102) {
        this.f390248a = r100;
        this.f390249b = r101;
        this.f390250c = r102;
    }
}

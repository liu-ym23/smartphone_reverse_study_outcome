package com.obric.assistant.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f390259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390260b;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f390259a == r101.f390259a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390260b, r101.f390260b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f390259a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f390260b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OAccountSnapshot(isLogin=" + this.f390259a + ", secUserId=" + this.f390260b + ')';
    }

    public /* synthetic */ g(int r100) {
        this(false, null);
    }

    public g(boolean r100, String r101) {
        this.f390259a = r100;
        this.f390260b = r101;
    }
}

package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f317347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f317348b;

    public m0() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f317347a, r101.f317347a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f317348b, r101.f317348b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f317347a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f317348b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuItemColor(darkMode=" + this.f317347a + ", lightMode=" + this.f317348b + ')';
    }

    public m0(String r100, String r101) {
        this.f317347a = r100;
        this.f317348b = r101;
    }
}

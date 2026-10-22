package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f411277b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f411276a, r101.f411276a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411277b, r101.f411277b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f411276a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f411277b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChameleonResInfo(revision=" + this.f411276a + ", version=" + this.f411277b + ')';
    }

    public b(int r100) {
        this.f411276a = null;
        this.f411277b = null;
    }
}

package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f316406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f316407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f316408d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f316405a, r101.f316405a) == true) goto L12;
        return false;
    L12:
        if (this.f316406b == r101.f316406b) goto L15;
        return false;
    L15:
        if (this.f316407c == r101.f316407c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f316408d, r101.f316408d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f316405a.hashCode() * 31) + this.f316406b) * 31) + this.f316407c) * 31;
        Integer r101 = this.f316408d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CollaboratedUpgradeBadge(iconUrl=" + this.f316405a + ", widthDp=" + this.f316406b + ", heightDp=" + this.f316407c + ", radiusDp=" + this.f316408d + ')';
    }

    public m0(String r100, int r101, int r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "iconUrl");
        this.f316405a = r100;
        this.f316406b = r101;
        this.f316407c = r102;
        this.f316408d = r103;
    }
}

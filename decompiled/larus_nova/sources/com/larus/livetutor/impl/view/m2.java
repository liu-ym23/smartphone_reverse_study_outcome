package com.larus.livetutor.impl.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f356870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f356871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f356872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f356873d;

    public m2() {
        this(0, null, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r101 = (m2) r100;
        if (this.f356870a == r101.f356870a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f356871b, r101.f356871b) == true) goto L15;
        return false;
    L15:
        if (this.f356872c == r101.f356872c) goto L18;
        return false;
    L18:
        if (this.f356873d == r101.f356873d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f356870a * 31) + this.f356871b.hashCode()) * 31;
        if (this.f356872c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f356873d;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TutorStarItem(id=" + this.f356870a + ", text=" + this.f356871b + ", isSelected=" + this.f356872c + ", size=" + this.f356873d + ')';
    }

    public m2(int r100, String r101, boolean r102, int r103) {
        int r104 = 0;
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r103 & 8) == 0) goto L14;
        r104 = l2.f356868a;
    L14:
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f356870a = r100;
        this.f356871b = r101;
        this.f356872c = r102;
        this.f356873d = r104;
    }
}

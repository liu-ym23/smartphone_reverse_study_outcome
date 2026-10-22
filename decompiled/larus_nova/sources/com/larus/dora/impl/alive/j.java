package com.larus.dora.impl.alive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f332011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f332012b;

    public j() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f332011a, r101.f332011a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f332012b, r101.f332012b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f332011a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f332012b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraKeepAliveHintItem(imgUrl=" + this.f332011a + ", text=" + this.f332012b + ')';
    }

    public j(String r100, String r101) {
        this.f332011a = r100;
        this.f332012b = r101;
    }
}

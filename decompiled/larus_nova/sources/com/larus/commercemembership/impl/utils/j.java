package com.larus.commercemembership.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325899a;

    public j() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f325899a, ((j) r100).f325899a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f325899a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "MembershipZlinkInfo(zlinkText=" + this.f325899a + ')';
    }

    public j(String r100) {
        this.f325899a = r100;
    }
}

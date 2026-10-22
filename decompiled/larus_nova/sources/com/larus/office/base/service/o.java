package com.larus.office.base.service;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f361121b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f361120a, r101.f361120a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361121b, r101.f361121b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f361120a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        byte[] r104 = this.f361121b;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WatermarkedImageResource(path=" + this.f361120a + ", data=" + Arrays.toString(this.f361121b) + ')';
    }

    public o(String r100, byte[] r101) {
        this.f361120a = r100;
        this.f361121b = r101;
    }
}

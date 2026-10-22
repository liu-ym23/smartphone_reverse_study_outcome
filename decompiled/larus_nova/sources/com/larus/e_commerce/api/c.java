package com.larus.e_commerce.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f342344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f342345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f342346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f342347d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f342344a == r101.f342344a) goto L12;
        return false;
    L12:
        if (this.f342345b == r101.f342345b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f342346c, r101.f342346c) == true) goto L18;
        return false;
    L18:
        if (this.f342347d == r101.f342347d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f342344a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f342345b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f342346c;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.f342347d == true) goto L19;
        r100 = 1237;
    L19:
        return r107 + r100;
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ECBindDouYinResult(isBind=" + this.f342344a + ", isNewBind=" + this.f342345b + ", clientEngineExtra=" + this.f342346c + ", isCancel=" + this.f342347d + ')';
    }

    public c(boolean r100, boolean r101, String r102, boolean r103) {
        this.f342344a = r100;
        this.f342345b = r101;
        this.f342346c = r102;
        this.f342347d = r103;
    }
}

package com.bytedance.badger.x;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f199426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f199427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f199428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f199429f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof y) == false) goto L25;
        y r101 = (y) r100;
        if (this.f199424a != r101.f199424a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L25;
        if (Intrinsics.areEqual(this.f199425b, r101.f199425b) == false) goto L25;
        if (Intrinsics.areEqual(this.f199426c, r101.f199426c) == false) goto L25;
        if (Intrinsics.areEqual(this.f199427d, r101.f199427d) == false) goto L25;
        if (Intrinsics.areEqual(this.f199428e, r101.f199428e) == false) goto L25;
        if (this.f199429f != r101.f199429f) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L25;
    L22:
        r103 = false;
        goto L23
    L9:
        r102 = false;
    L25:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public final int hashCode() {
        int r100 = this.f199424a * 31;
        String r101 = this.f199425b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        z r105 = this.f199426c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f199427d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f199428e;
        if (r111 == null) goto L17;
        r102 = r111.hashCode();
    L17:
        int r112 = (r110 + r102) * 31;
        boolean r113 = this.f199429f;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        return r112 + r114;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DeviceFp1Result(errCode=" + this.f199424a + ", errMsg=" + this.f199425b + ", supportInfo=" + this.f199426c + ", deviceFp1=" + this.f199427d + ", type=" + this.f199428e + ", useCache=" + this.f199429f + ")";
    }

    public y(int r100, String r101, z r102, String r103, String r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = null;
    L8:
        this.f199424a = r100;
        this.f199425b = r101;
        this.f199426c = r102;
        this.f199427d = r103;
        this.f199428e = r104;
        this.f199429f = false;
    }
}

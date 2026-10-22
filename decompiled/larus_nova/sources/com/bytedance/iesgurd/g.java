package com.bytedance.iesgurd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f250691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f250692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f250693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f250694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f250695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f250696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f250697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f250698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f250699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f250700j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L26;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f250691a, r101.f250691a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250692b, r101.f250692b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f250693c, r101.f250693c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250694d, r101.f250694d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f250695e, r101.f250695e) == true) goto L16;
        return false;
    L16:
        if (this.f250696f == r101.f250696f) goto L18;
        return false;
    L18:
        if (this.f250697g == r101.f250697g) goto L20;
        return false;
    L20:
        if (this.f250698h == r101.f250698h) goto L22;
        return false;
    L22:
        if (this.f250699i == r101.f250699i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f250700j, r101.f250700j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f250691a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f250692b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f250693c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f250694d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f250695e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f250696f;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        boolean r120 = this.f250697g;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.f250698h;
        ?? r124 = r123;
        if (r123 == false) goto L31;
        r124 = 1;
    L31:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f250699i;
        if (r126 == true) goto L35;
        r117 = r126;
    L35:
        int r127 = (r125 + r117) * 31;
        String r128 = this.f250700j;
        if (r128 == null) goto L39;
        r101 = r128.hashCode();
    L39:
        return r127 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdResParams(tag=" + this.f250691a + ", accessKey=" + this.f250692b + ", channel=" + this.f250693c + ", bundle=" + this.f250694d + ", version=" + this.f250695e + ", skipCdn=" + this.f250696f + ", getCdnSync=" + this.f250697g + ", waitUpdate=" + this.f250698h + ", ignoreAccess=" + this.f250699i + ", rootDir=" + this.f250700j + ")";
    }

    public g(String r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106, int r110) {
        if ((r110 & 16) == 0) goto L6;
        r104 = false;
    L6:
        if ((r110 & 64) == 0) goto L9;
        r105 = false;
    L9:
        if ((r110 & 256) == 0) goto L11;
        r106 = null;
    L11:
        this.f250691a = r100;
        this.f250692b = r101;
        this.f250693c = r102;
        this.f250694d = r103;
        this.f250695e = null;
        this.f250696f = r104;
        this.f250697g = false;
        this.f250698h = r105;
        this.f250699i = false;
        this.f250700j = r106;
    }
}

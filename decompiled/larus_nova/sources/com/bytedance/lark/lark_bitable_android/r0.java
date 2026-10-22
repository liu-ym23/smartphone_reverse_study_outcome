package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f253107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f253108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f253109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f253111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f253112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f253113h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f253106a, r101.f253106a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253107b, r101.f253107b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253108c, r101.f253108c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253109d, r101.f253109d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253110e, r101.f253110e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f253111f, r101.f253111f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f253112g, r101.f253112g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f253113h, r101.f253113h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f253106a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f253107b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f253108c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f253109d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f253110e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f253111f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f253112g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f253113h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PushBitableLoaderResource(containerId=" + this.f253106a + ", blockId=" + this.f253107b + ", viewId=" + this.f253108c + ", clientvars=" + this.f253109d + ", mainPage=" + this.f253110e + ", blockType=" + this.f253111f + ", recordData=" + this.f253112g + ", addRecordPage=" + this.f253113h + ')';
    }

    public r0(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, String r107) {
        this.f253106a = r100;
        this.f253107b = r101;
        this.f253108c = r102;
        this.f253109d = r103;
        this.f253110e = r104;
        this.f253111f = r105;
        this.f253112g = r106;
        this.f253113h = r107;
    }
}

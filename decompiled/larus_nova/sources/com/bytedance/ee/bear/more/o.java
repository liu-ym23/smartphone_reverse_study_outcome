package com.bytedance.ee.bear.more;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f234666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f234669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f234671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f234672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f234673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f234675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f234676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f234677l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f234666a, r101.f234666a) == true) goto L12;
        return false;
    L12:
        if (this.f234667b == r101.f234667b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234668c, r101.f234668c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234669d, r101.f234669d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234670e, r101.f234670e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234671f, r101.f234671f) == true) goto L27;
        return false;
    L27:
        if (this.f234672g == r101.f234672g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234673h, r101.f234673h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234674i, r101.f234674i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234675j, r101.f234675j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234676k, r101.f234676k) == true) goto L42;
        return false;
    L42:
        if (this.f234677l == r101.f234677l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f234666a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f234667b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f234668c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f234669d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f234670e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f234671f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.f234672g) * 31;
        String r119 = this.f234673h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f234674i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f234675j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f234676k;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        int r129 = (r127 + r101) * 31;
        if (this.f234677l == true) goto L47;
        r104 = 1237;
    L47:
        return r129 + r104;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublicParams(params=" + this.f234666a + ", isOwner=" + this.f234667b + ", userPermission=" + this.f234668c + ", module=" + this.f234669d + ", subModule=" + this.f234670e + ", objToken=" + this.f234671f + ", fileType=" + this.f234672g + ", subFileType=" + this.f234673h + ", containerId=" + this.f234674i + ", containerType=" + this.f234675j + ", shortcutToken=" + this.f234676k + ", isAtVc=" + this.f234677l + ')';
    }

    public o(JSONObject r100, boolean r101, String r102, String r103, String r104, String r105, int r106, String r107, String r108, String r110, String r111, boolean r112) {
        this.f234666a = r100;
        this.f234667b = r101;
        this.f234668c = r102;
        this.f234669d = r103;
        this.f234670e = r104;
        this.f234671f = r105;
        this.f234672g = r106;
        this.f234673h = r107;
        this.f234674i = r108;
        this.f234675j = r110;
        this.f234676k = r111;
        this.f234677l = r112;
    }
}

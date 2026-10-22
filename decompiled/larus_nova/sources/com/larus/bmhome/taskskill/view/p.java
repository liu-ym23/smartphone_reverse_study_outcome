package com.larus.bmhome.taskskill.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f314641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f314642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f314643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PcConnectionStatusAction f314644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f314645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f314646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f314647g;

    public p() {
        this(null, null, null, null, false, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f314641a, r101.f314641a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314642b, r101.f314642b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314643c, r101.f314643c) == true) goto L18;
        return false;
    L18:
        if (this.f314644d == r101.f314644d) goto L21;
        return false;
    L21:
        if (this.f314645e == r101.f314645e) goto L24;
        return false;
    L24:
        if (this.f314646f == r101.f314646f) goto L27;
        return false;
    L27:
        if (this.f314647g == r101.f314647g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f314641a.hashCode() * 31) + this.f314642b.hashCode()) * 31;
        CharSequence r101 = this.f314643c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        PcConnectionStatusAction r105 = this.f314644d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.f314645e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f314646f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f314647g == true) goto L23;
        r107 = 1237;
    L23:
        return r111 + r107;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcConnectionStatusUiModel(deviceName=" + this.f314641a + ", hintText=" + this.f314642b + ", actionText=" + this.f314643c + ", action=" + this.f314644d + ", shimmer=" + this.f314645e + ", visible=" + this.f314646f + ", directUseHint=" + this.f314647g + ')';
    }

    public p(CharSequence r100, CharSequence r101, CharSequence r102, PcConnectionStatusAction r103, boolean r104, boolean r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = true;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = false;
    L20:
        Intrinsics.checkNotNullParameter(r100, "deviceName");
        Intrinsics.checkNotNullParameter(r101, "hintText");
        this.f314641a = r100;
        this.f314642b = r101;
        this.f314643c = r102;
        this.f314644d = r103;
        this.f314645e = false;
        this.f314646f = r104;
        this.f314647g = r105;
    }
}

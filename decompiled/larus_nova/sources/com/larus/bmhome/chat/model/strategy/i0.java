package com.larus.bmhome.chat.model.strategy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f308071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f308072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f308073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f308074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f308075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f308076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f308077g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f308071a, r101.f308071a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308072b, r101.f308072b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308073c, r101.f308073c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f308074d, r101.f308074d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f308075e, r101.f308075e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f308076f, r101.f308076f) == true) goto L27;
        return false;
    L27:
        if (this.f308077g == r101.f308077g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f308071a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f308072b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f308073c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f308074d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f308075e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f308076f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.f308077g;
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
        return "ParsedPPTOption(label=" + this.f308071a + ", pageSizeId=" + this.f308072b + ", pageSizeName=" + this.f308073c + ", templateId=" + this.f308074d + ", templateType=" + this.f308075e + ", templateName=" + this.f308076f + ", optionType=" + this.f308077g + ')';
    }

    public i0() {
        this("", "", "", "", "", "", PPTOptionType.UNKNOWN.getType());
    }

    public i0(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
        this.f308071a = r100;
        this.f308072b = r101;
        this.f308073c = r102;
        this.f308074d = r103;
        this.f308075e = r104;
        this.f308076f = r105;
        this.f308077g = r106;
    }
}
